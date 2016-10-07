package com.grocerystore.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.grocerystore.model.Item;

public class ItemMapper implements RowMapper {

        private static Logger logger = Logger.getLogger(ItemMapper.class);

        public Object mapRow(ResultSet rs, int arg1) throws SQLException {

            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setTitle(rs.getString("title"));
            item.setCover(rs.getString("cover"));
            item.setNutritionalImage(rs.getString("nutritional_image"));
            item.setAvailability(rs.getInt("availability"));
            item.setNextAvailability(rs.getTimestamp("next_availability"));
            item.setFullPrice(rs.getBigDecimal("full_price"));
            item.setDiscount(rs.getBoolean("discount"));
            item.setDiscountPercentage(rs.getInt("discount_perc"));
            item.setDiscountPrice(rs.getBigDecimal("discount_price"));
            item.setDiscountFrom(rs.getTimestamp("discount_from"));
            item.setDiscountTo(rs.getTimestamp("discount_to"));
            item.setCreatedAt(rs.getTimestamp("created_at"));
            item.setUpdatedAt(rs.getTimestamp("updated_at"));
            item.setStatus(rs.getInt("status"));
            item.setTag(rs.getString("tag"));

            return item;
        }
   
}
