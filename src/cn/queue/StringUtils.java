/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.queue;

import java.util.ArrayList;
import java.util.List;
public class StringUtils {

	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	
	  public static String[] split(String str, String separatorChars) {
	        return splitWorker(str, separatorChars, -1, false);
	    }

		  private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
	        // Performance tuned for 2.0 (JDK1.4)
	        // Direct code is quicker than StringTokenizer.
	        // Also, StringTokenizer uses isSpace() not isWhitespace()

	        if (str == null) {
	            return null;
	        }
	        int len = str.length();
	        if (len == 0) {
	            return EMPTY_STRING_ARRAY;
	        }
	        List list = new ArrayList();
	        int sizePlus1 = 1;
	        int i = 0, start = 0;
	        boolean match = false;
	        boolean lastMatch = false;
	        if (separatorChars == null) {
	            // Null separator means use whitespace
	            while (i < len) {
	                if (Character.isWhitespace(str.charAt(i))) {
	                    if (match || preserveAllTokens) {
	                        lastMatch = true;
	                        if (sizePlus1++ == max) {
	                            i = len;
	                            lastMatch = false;
	                        }
	                        list.add(str.substring(start, i));
	                        match = false;
	                    }
	                    start = ++i;
	                    continue;
	                }
	                lastMatch = false;
	                match = true;
	                i++;
	            }
	        } else if (separatorChars.length() == 1) {
	            // Optimise 1 character case
	            char sep = separatorChars.charAt(0);
	            while (i < len) {
	                if (str.charAt(i) == sep) {
	                    if (match || preserveAllTokens) {
	                        lastMatch = true;
	                        if (sizePlus1++ == max) {
	                            i = len;
	                            lastMatch = false;
	                        }
	                        list.add(str.substring(start, i));
	                        match = false;
	                    }
	                    start = ++i;
	                    continue;
	                }
	                lastMatch = false;
	                match = true;
	                i++;
	            }
	        } else {
	            // standard case
	            while (i < len) {
	                if (separatorChars.indexOf(str.charAt(i)) >= 0) {
	                    if (match || preserveAllTokens) {
	                        lastMatch = true;
	                        if (sizePlus1++ == max) {
	                            i = len;
	                            lastMatch = false;
	                        }
	                        list.add(str.substring(start, i));
	                        match = false;
	                    }
	                    start = ++i;
	                    continue;
	                }
	                lastMatch = false;
	                match = true;
	                i++;
	            }
	        }
	        if (match || (preserveAllTokens && lastMatch)) {
	            list.add(str.substring(start, i));
	        }
	        return (String[]) list.toArray(new String[list.size()]);
	    }
}
