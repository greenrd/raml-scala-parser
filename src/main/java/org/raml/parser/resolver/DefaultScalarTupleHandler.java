/*
 * Copyright (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.parser.resolver;

import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class DefaultScalarTupleHandler implements TupleHandler
{


    private String fieldName;

    public DefaultScalarTupleHandler(String fieldName)
    {
        this.fieldName = fieldName;
    }

    @Override
    public boolean handles(NodeTuple tuple)
    {
    	
        if (tuple.getKeyNode() instanceof ScalarNode)      	
        {
            return fieldName == null || fieldName.equals(((ScalarNode) tuple.getKeyNode()).getValue());
        }
        return false;
    }
}
