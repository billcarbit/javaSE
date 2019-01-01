package beanconvert.bean;

import beanconvert.ValueFrom;

public class ControllerBean extends DaoBean {
    @ValueFrom(superFiled="daoId")
    private String controllerId;
    @ValueFrom(superFiled="daoName")
    private String controllerName;

    public String getControllerId() {
        return controllerId;
    }

    public void setControllerId(String controllerId) {
        this.controllerId = controllerId;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }
}
