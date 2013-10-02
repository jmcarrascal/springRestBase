package bo.gob.aduana.base.model;

public class JsonResult {

    private Boolean success;
    private Object result;

    public JsonResult(Boolean success, Object result) {
        this.success = success;
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


}
