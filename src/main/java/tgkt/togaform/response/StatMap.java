package tgkt.togaform.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatMap implements Serializable {
    protected String name;
    protected int value = 0;
}
