package com.npst.TEST_CRUD_APP.Messages;

public class ResponseDto {
        private String status;
        private Object data;

        public ResponseDto() {
        }

        public ResponseDto(String status, Object data) {
                this.status = status;
                this.data = data;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public Object getData() {
                return data;
        }

        public void setData(Object data) {
                this.data = data;
        }
}
