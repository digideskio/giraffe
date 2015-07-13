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
package com.palantir.giraffe.ssh.util;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.palantir.giraffe.file.test.runner.FileSystemTestRule;

/**
 * Connects to a remote SSH server for file system tests.
 *
 * @author bkeyes
 */
public class RemoteSshFileSystemRule extends RemoteSshSystemRule implements FileSystemTestRule {

    public RemoteSshFileSystemRule(String name, String workingDir) {
        super(name, workingDir);
    }

    @Override
    public Path getIncompatiblePath() {
        return Paths.get("local");
    }

}
