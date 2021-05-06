/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Adrian
 */
public class ProcessController {
    
    String name;
    String waitingFrom;
    boolean active;
    MessageLog messageLog;
    String synchronizationMode, sendMode, receiveMode, 
           addressingMode, directAddressing, receiveAddressing, indirectAddressing, 
           format, formatLength;
    boolean queueMode;

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWaitingFrom() {
        return waitingFrom;
    }

    public void setWaitingFrom(String waitingFrom) {
        this.waitingFrom = waitingFrom;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public MessageLog getMessageLog() {
        return messageLog;
    }

    public void setMessageLog(MessageLog MessageLog) {
        this.messageLog = MessageLog;
    }

    public String getSynchronizationMode() {
        return synchronizationMode;
    }

    public void setSynchronizationMode(String synchronizationMode) {
        this.synchronizationMode = synchronizationMode;
    }

    public String getSendMode() {
        return sendMode;
    }

    public void setSendMode(String sendMode) {
        this.sendMode = sendMode;
    }

    public String getReceiveMode() {
        return receiveMode;
    }

    public void setReceiveMode(String receiveMode) {
        this.receiveMode = receiveMode;
    }

    public String getAddressingMode() {
        return addressingMode;
    }

    public void setAddressingMode(String addressingMode) {
        this.addressingMode = addressingMode;
    }

    public String getDirectAddressing() {
        return directAddressing;
    }

    public void setDirectAddressing(String directAddressing) {
        this.directAddressing = directAddressing;
    }

    public String getReceiveAddressing() {
        return receiveAddressing;
    }

    public void setReceiveAddressing(String receiveAddressing) {
        this.receiveAddressing = receiveAddressing;
    }

    public String getIndirectAddressing() {
        return indirectAddressing;
    }

    public void setIndirectAddressing(String indirectAddressing) {
        this.indirectAddressing = indirectAddressing;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormatLength() {
        return formatLength;
    }

    public void setFormatLength(String formatLength) {
        this.formatLength = formatLength;
    }

    public boolean isQueueMode() {
        return queueMode;
    }

    public void setQueueMode(boolean queueMode) {
        this.queueMode = queueMode;
    }// </editor-fold>

    public ProcessController(String name, boolean active, MessageLog messageLog, 
           String synchronizationMode, String sendMode, String receiveMode, 
           String addressingMode, String directAddressing, String receiveAddressing, String indirectAddressing, 
           String format, String formatLength, boolean queueMode) {
        
        this.name = name;
        this.active = active;
        this.messageLog = messageLog;
        this.synchronizationMode = synchronizationMode;
        this.sendMode = sendMode;
        this.receiveMode = receiveMode;
        this.addressingMode = addressingMode;
        this.directAddressing = directAddressing;
        this.receiveAddressing = receiveAddressing;
        this.indirectAddressing = indirectAddressing;
        this.format = format;
        this.formatLength = formatLength;
        this.queueMode = queueMode;
    }
    
    
    
}

