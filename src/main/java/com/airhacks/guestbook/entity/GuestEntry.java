
package com.airhacks.guestbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GuestEntry {

    @Id
    @GeneratedValue
    private long id;
    private String content;

    public GuestEntry(String content) {
        this.content = content;
    }

    protected GuestEntry() {
    }

}
