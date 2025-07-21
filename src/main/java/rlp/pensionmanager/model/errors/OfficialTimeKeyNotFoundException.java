package rlp.pensionmanager.model.errors;

import java.text.MessageFormat;

public class OfficialTimeKeyNotFoundException extends RuntimeException {

    public OfficialTimeKeyNotFoundException(final long id){
        super(MessageFormat.format("Could not find duty_hour with id: {0}", id));
    }
}
