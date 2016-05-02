package com.kursova.kep.custom;

/**
 * Created by Mr. Skip.
 */

public class ValuesForTaskLabels {

    private String
            name,
            uri,
            title,
            format,
            param;

    private Class returnedClass;

    public ValuesForTaskLabels(String name, String uri, String title, String format, Class returnedClass) {
        this.name = name;
        this.uri = uri;
        this.title = title;
        this.format = format;
        this.returnedClass = returnedClass;
    }

    public ValuesForTaskLabels(String name, String uri, String title, Class returnedClass) {
        this.name = name;
        this.uri = uri;
        this.title = title;
        this.returnedClass = returnedClass;
    }

    public ValuesForTaskLabels(String name, String uri, String title, Class returnedClass, String param) {
        this.name = name;
        this.uri = uri;
        this.title = title;
        this.returnedClass = returnedClass;
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Class getReturnedClass() {
        return returnedClass;
    }

    public void setReturnedClass(Class returnedClass) {
        this.returnedClass = returnedClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
