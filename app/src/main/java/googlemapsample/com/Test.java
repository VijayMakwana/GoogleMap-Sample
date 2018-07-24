package googlemapsample.com;

public class Test {

    /**
     * id : 1c71ec4f034491b0084c477c189bc72a6
     * type : APPLOZIC_01
     * message : {"key":"4-be5550fb-154e-48a4-85f5-0520a1b0f51b-1531918854519","userKey":"345eb663-de50-4bee-8c1d-2d793cecfc3f","to":"17642","contactIds":"17642","fromUserName":"Vijay","message":"Gg","sent":false,"delivered":false,"read":false,"deliveredValue":0,"sendToDevice":false,"shared":false,"createdAtTime":1531918858105,"createdAt":"Jul 18, 2018 1:00:58 PM","type":4,"source":2,"status":0,"pairedMessageKey":"5-be5550fb-154e-48a4-85f5-0520a1b0f51b-1531918854519","applicationKey":"f365a19e-abb0-474c-9615-5ac28e67c1e4","contentType":0,"senderName":"14614","metadata":{"MESSAGE_CREATED_ACTUAL_LOCAL_TIME":"1531918854519"},"alert":true}
     * notifyUser : true
     * totalUnreadCount : 201
     * sendAlert : true
     * messageMetaData : {}
     */

    private String id;
    private String type;
    private MessageBean message;
    private boolean notifyUser;
    private int totalUnreadCount;
    private boolean sendAlert;
    private MessageMetaDataBean messageMetaData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public boolean isNotifyUser() {
        return notifyUser;
    }

    public void setNotifyUser(boolean notifyUser) {
        this.notifyUser = notifyUser;
    }

    public int getTotalUnreadCount() {
        return totalUnreadCount;
    }

    public void setTotalUnreadCount(int totalUnreadCount) {
        this.totalUnreadCount = totalUnreadCount;
    }

    public boolean isSendAlert() {
        return sendAlert;
    }

    public void setSendAlert(boolean sendAlert) {
        this.sendAlert = sendAlert;
    }

    public MessageMetaDataBean getMessageMetaData() {
        return messageMetaData;
    }

    public void setMessageMetaData(MessageMetaDataBean messageMetaData) {
        this.messageMetaData = messageMetaData;
    }

    public static class MessageBean {
        /**
         * key : 4-be5550fb-154e-48a4-85f5-0520a1b0f51b-1531918854519
         * userKey : 345eb663-de50-4bee-8c1d-2d793cecfc3f
         * to : 17642
         * contactIds : 17642
         * fromUserName : Vijay
         * message : Gg
         * sent : false
         * delivered : false
         * read : false
         * deliveredValue : 0
         * sendToDevice : false
         * shared : false
         * createdAtTime : 1531918858105
         * createdAt : Jul 18, 2018 1:00:58 PM
         * type : 4
         * source : 2
         * status : 0
         * pairedMessageKey : 5-be5550fb-154e-48a4-85f5-0520a1b0f51b-1531918854519
         * applicationKey : f365a19e-abb0-474c-9615-5ac28e67c1e4
         * contentType : 0
         * senderName : 14614
         * metadata : {"MESSAGE_CREATED_ACTUAL_LOCAL_TIME":"1531918854519"}
         * alert : true
         */

        private String key;
        private String userKey;
        private String to;
        private String contactIds;
        private String fromUserName;
        private String message;
        private boolean sent;
        private boolean delivered;
        private boolean read;
        private int deliveredValue;
        private boolean sendToDevice;
        private boolean shared;
        private long createdAtTime;
        private String createdAt;
        private int type;
        private int source;
        private int status;
        private String pairedMessageKey;
        private String applicationKey;
        private int contentType;
        private String senderName;
        private MetadataBean metadata;
        private boolean alert;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUserKey() {
            return userKey;
        }

        public void setUserKey(String userKey) {
            this.userKey = userKey;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getContactIds() {
            return contactIds;
        }

        public void setContactIds(String contactIds) {
            this.contactIds = contactIds;
        }

        public String getFromUserName() {
            return fromUserName;
        }

        public void setFromUserName(String fromUserName) {
            this.fromUserName = fromUserName;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isSent() {
            return sent;
        }

        public void setSent(boolean sent) {
            this.sent = sent;
        }

        public boolean isDelivered() {
            return delivered;
        }

        public void setDelivered(boolean delivered) {
            this.delivered = delivered;
        }

        public boolean isRead() {
            return read;
        }

        public void setRead(boolean read) {
            this.read = read;
        }

        public int getDeliveredValue() {
            return deliveredValue;
        }

        public void setDeliveredValue(int deliveredValue) {
            this.deliveredValue = deliveredValue;
        }

        public boolean isSendToDevice() {
            return sendToDevice;
        }

        public void setSendToDevice(boolean sendToDevice) {
            this.sendToDevice = sendToDevice;
        }

        public boolean isShared() {
            return shared;
        }

        public void setShared(boolean shared) {
            this.shared = shared;
        }

        public long getCreatedAtTime() {
            return createdAtTime;
        }

        public void setCreatedAtTime(long createdAtTime) {
            this.createdAtTime = createdAtTime;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getPairedMessageKey() {
            return pairedMessageKey;
        }

        public void setPairedMessageKey(String pairedMessageKey) {
            this.pairedMessageKey = pairedMessageKey;
        }

        public String getApplicationKey() {
            return applicationKey;
        }

        public void setApplicationKey(String applicationKey) {
            this.applicationKey = applicationKey;
        }

        public int getContentType() {
            return contentType;
        }

        public void setContentType(int contentType) {
            this.contentType = contentType;
        }

        public String getSenderName() {
            return senderName;
        }

        public void setSenderName(String senderName) {
            this.senderName = senderName;
        }

        public MetadataBean getMetadata() {
            return metadata;
        }

        public void setMetadata(MetadataBean metadata) {
            this.metadata = metadata;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }

        public static class MetadataBean {
            /**
             * MESSAGE_CREATED_ACTUAL_LOCAL_TIME : 1531918854519
             */

            private String MESSAGE_CREATED_ACTUAL_LOCAL_TIME;

            public String getMESSAGE_CREATED_ACTUAL_LOCAL_TIME() {
                return MESSAGE_CREATED_ACTUAL_LOCAL_TIME;
            }

            public void setMESSAGE_CREATED_ACTUAL_LOCAL_TIME(String MESSAGE_CREATED_ACTUAL_LOCAL_TIME) {
                this.MESSAGE_CREATED_ACTUAL_LOCAL_TIME = MESSAGE_CREATED_ACTUAL_LOCAL_TIME;
            }
        }
    }

    public static class MessageMetaDataBean {
    }
}
