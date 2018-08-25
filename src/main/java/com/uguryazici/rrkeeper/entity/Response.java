package com.uguryazici.rrkeeper.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Response {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String host;

    @Column
    private String body;

    @ManyToOne
    @JoinColumn(name="REQUEST_ID")
    @JsonBackReference
    private Request request;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="RESPONSE_HEADER",
            joinColumns=@JoinColumn(name="RESPONSE_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="HEADER_ID", referencedColumnName="ID"))
    private List<Header> headers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
