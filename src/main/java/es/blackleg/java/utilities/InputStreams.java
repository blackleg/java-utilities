/*
 * Copyright 2016 hector.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.blackleg.java.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author hector
 */
public class InputStreams {
    
    public static byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int read = inputStream.read();
                while (read != -1){
                    byteArrayOutputStream.write(read);
                    read = inputStream.read();
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                return null;
            }
        }
    }
    
}
