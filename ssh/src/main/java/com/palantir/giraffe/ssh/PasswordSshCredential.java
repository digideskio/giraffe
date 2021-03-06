/**
 * Copyright 2015 Palantir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.palantir.giraffe.ssh;

import java.io.IOException;

/**
 * Authenticates SSH connections using a password.
 *
 * @author bkeyes
 */
public final class PasswordSshCredential extends SshCredential {

    public static PasswordSshCredential of(String username, String password) {
        return new PasswordSshCredential(username, password.toCharArray());
    }

    public static PasswordSshCredential of(String username, char[] password) {
        return new PasswordSshCredential(username, password);
    }

    private final char[] password;

    private PasswordSshCredential(String username, char[] password) {
        super(username);
        this.password = password.clone();
    }

    @Override
    public void authenticate(SshAuthenticator authenticator) throws IOException {
        authenticator.authByPassword(this);
    }

    public char[] getPassword() {
        return password.clone();
    }
}
