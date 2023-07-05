package com.dogsong.domain.pojo;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * DeviceMessage
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/26
 */
@Data
@XmlRootElement(name = "xml")
public class DeviceMessage implements Serializable {

    private static final long serialVersionUID = -1L;

    // @XmlElement(name = "version")
    private String version;

    // @XmlElement(name = "msg")
    private String msg;

    // @XmlElement(name = "id")
    private int id;

}
