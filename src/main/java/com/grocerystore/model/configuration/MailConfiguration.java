package com.grocerystore.model.configuration;

public class MailConfiguration {

    /* common  */
    private String smtpHost;
    private String smtpAuth;
    private String smtpPort;
    private String receiver;

    /* tls */
    private String smtpStartTls;

    /* ssl */
    private String smtpSocketPort;
    private String smtpSocketClass;

    /* authentication */
    private String sender;
    private String senderUsr;
    private String senderPwd;

    public MailConfiguration(String smtpHost, String smtpAuth, String smtpPort,
            String receiver, String smtpStartTls, String smtpSocketPort,
            String smtpSocketClass, String sender, String senderUsr, String senderPwd) {

        this.smtpHost = smtpHost;
        this.smtpAuth = smtpAuth;
        this.smtpPort = smtpPort;
        this.receiver = receiver;
        this.smtpStartTls = smtpStartTls;
        this.smtpSocketPort = smtpSocketPort;
        this.smtpSocketClass = smtpSocketClass;
        this.sender = sender;
        this.senderUsr = senderUsr;
        this.senderPwd = senderPwd;
    }

    public String getSmtpHost() {
        return smtpHost;
    }
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }
    public String getSmtpAuth() {
        return smtpAuth;
    }
    public void setSmtpAuth(String smtpAuth) {
        this.smtpAuth = smtpAuth;
    }
    public String getSmtpPort() {
        return smtpPort;
    }
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getSmtpStartTls() {
        return smtpStartTls;
    }
    public void setSmtpStartTls(String smtpStartTls) {
        this.smtpStartTls = smtpStartTls;
    }
    public String getSmtpSocketPort() {
        return smtpSocketPort;
    }
    public void setSmtpSocketPort(String smtpSocketPort) {
        this.smtpSocketPort = smtpSocketPort;
    }
    public String getSmtpSocketClass() {
        return smtpSocketClass;
    }
    public void setSmtpSocketClass(String smtpSocketClass) {
        this.smtpSocketClass = smtpSocketClass;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getSenderPwd() {
        return senderPwd;
    }
    public void setSenderPwd(String senderPwd) {
        this.senderPwd = senderPwd;
    }
    public String getSenderUsr() {
        return senderUsr;
    }
    public void setSenderUsr(String senderUsr) {
        this.senderUsr = senderUsr;
    }

    @Override
    public String toString() {
        return "MailConfiguration [smtpHost=" + smtpHost + ", smtpAuth="
                + smtpAuth + ", smtpPort=" + smtpPort + ", receiver=" + receiver
                + ", smtpStartTls=" + smtpStartTls + ", smtpSocketPort="
                + smtpSocketPort + ", smtpSocketClass=" + smtpSocketClass
                + ", sender=" + sender + ", senderUsr=" + senderUsr
                + ", senderPwd=" + senderPwd + "]";
    }

}
