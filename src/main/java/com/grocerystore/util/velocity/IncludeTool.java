package com.grocerystore.util.velocity;

import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.view.ViewToolContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DefaultKey("includeTool")

public class IncludeTool {

    private static final Logger logger = LoggerFactory.getLogger(IncludeTool.class);

	protected VelocityEngine engine;
	
	public void configure(Map params){
    	logger.info("Configure over Map on our Velocity Tool");
        configure((ViewToolContext)params.get(ViewToolContext.CONTEXT_KEY));
    }

    protected void configure(ViewToolContext ctx){
    	logger.info("Configure over Ctx on our Velocity Tool");
    	this.engine = ctx.getVelocityEngine();
    }
    
	public boolean exist(String filename){
    	logger.info("Verify Exist:" + filename);
		return this.engine.resourceExists(filename);
	}
}
