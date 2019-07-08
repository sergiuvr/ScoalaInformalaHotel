package sih.app.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class HasId {

    @EqualsAndHashCode.Exclude
    private long id;

    public HasId(long id){
        this.id = id;
    }

}
