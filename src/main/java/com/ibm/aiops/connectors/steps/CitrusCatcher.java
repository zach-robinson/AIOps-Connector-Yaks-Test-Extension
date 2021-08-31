package com.ibm.aiops.connectors.steps;

import com.consol.citrus.exceptions.CitrusRuntimeException;

public class CitrusCatcher {
    public static void throwExceptionsAsCitrus(CitrusRuntimeThrower c) throws CitrusRuntimeException {
        try {
            c.run();
        } catch (Exception e) {
            throw new CitrusRuntimeException(e);
        }
    }
}
