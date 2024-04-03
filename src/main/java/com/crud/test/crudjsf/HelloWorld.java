package com.crud.test.crudjsf;

import javax.faces.bean.ManagedBean;



/**
 *
 * @author Rishabh
 */

@ManagedBean(name = "helloWorld")
public class HelloWorld {

    private String value = "This editor is provided by PrimeFaces";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
