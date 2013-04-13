package com.mydomain.pkg.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

    boolean authenticate();

}
