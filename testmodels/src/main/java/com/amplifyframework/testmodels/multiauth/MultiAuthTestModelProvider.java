/*
 * Copyright 2022 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amplifyframework.testmodels.multiauth;

import com.amplifyframework.util.Immutable;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelProvider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/** 
 *  Contains the set of model classes that implement {@link Model}
 * interface.
 */

public final class MultiAuthTestModelProvider implements ModelProvider {
  private static final String AMPLIFY_MODEL_VERSION = "52428e395c1e7bccd45653eae49c294d";
  private static MultiAuthTestModelProvider amplifyGeneratedModelInstance;

  private final List<Class<? extends Model>> loadedModels;
  private MultiAuthTestModelProvider(List<Class<? extends Model>> modelsToLoad) {
      loadedModels = modelsToLoad;
  }
  
  public static MultiAuthTestModelProvider getInstance(List<Class<? extends Model>> modelsToLoad) {
      amplifyGeneratedModelInstance = new MultiAuthTestModelProvider(modelsToLoad);
        return amplifyGeneratedModelInstance;
  }
  
  /** 
   * Get a set of the model classes.
   * 
   * @return a set of the model classes.
   */
  @Override
   public Set<Class<? extends Model>> models() {
        return Immutable.of(new HashSet<>(loadedModels));
  }
  
  /** 
   * Get the version of the models.
   * 
   * @return the version string of the models.
   */
  @Override
   public String version() {
    return AMPLIFY_MODEL_VERSION;
  }
}
