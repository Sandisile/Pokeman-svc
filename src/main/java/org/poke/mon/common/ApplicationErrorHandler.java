package org.poke.mon.common;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author bruce
 */

/**
 *  This class handles all the exceptions
 * @author bruce
 */
@Provider
@Slf4j
public class ApplicationErrorHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        log.error("error occurred!", e);
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Ooops!, something went wrong try again later")
                .build();
    }
    
}
