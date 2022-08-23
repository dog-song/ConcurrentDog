package com.dogsong.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * SocketMessage
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/8/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketMessage {

    private String message;

    private Date sendDate;

}
