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

package com.amplifyframework.testmodels.ownerauth;


import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import java.util.Objects;
import java.util.UUID;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the OwnerAuth type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "OwnerAuths", authRules = {
        @AuthRule(
            allow = AuthStrategy.OWNER,
            ownerField = "owner",
            identityClaim = "cognito:username",
            operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }
        )
})
public final class OwnerAuth implements Model {
    public static final QueryField ID = field("id");
    public static final QueryField TITLE = field("title");
    private final @ModelField(targetType="ID", isRequired = true) String id;
    private final @ModelField(targetType="String", isRequired = true) String title;
    @NonNull
    public String resolveIdentifier() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    private OwnerAuth(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            OwnerAuth ownerAuth = (OwnerAuth) obj;
            return ObjectsCompat.equals(getId(), ownerAuth.getId()) &&
                    ObjectsCompat.equals(getTitle(), ownerAuth.getTitle());
        }
    }

    @Override
    public int hashCode() {
        return new StringBuilder()
                .append(getId())
                .append(getTitle())
                .toString()
                .hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("OwnerAuth {")
                .append("id=" + String.valueOf(getId()) + ", ")
                .append("title=" + String.valueOf(getTitle()))
                .append("}")
                .toString();
    }

    public static TitleStep builder() {
        return new Builder();
    }

    /**
     * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
     * This is a convenience method to return an instance of the object with only its ID populated
     * to be used in the context of a parameter in a delete mutation or referencing a foreign key
     * in a relationship.
     * @param id the id of the existing item this instance will represent
     * @return an instance of this model with only ID populated
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public static OwnerAuth justId(String id) {
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
            throw new IllegalArgumentException(
                    "Model IDs must be unique in the format of UUID. This method is for creating instances " +
                            "of an existing object with only its ID field for sending as a mutation parameter. When " +
                            "creating a new object, use the standard builder method and leave the ID field blank."
            );
        }
        return new OwnerAuth(
                id,
                null
        );
    }

    public CopyOfBuilder copyOfBuilder() {
        return new CopyOfBuilder(id,
                title);
    }
    public interface TitleStep {
        BuildStep title(String title);
    }


    public interface BuildStep {
        OwnerAuth build();
        BuildStep id(String id) throws IllegalArgumentException;
    }


    public static class Builder implements TitleStep, BuildStep {
        private String id;
        private String title;
        @Override
        public OwnerAuth build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new OwnerAuth(
                    id,
                    title);
        }

        @Override
        public BuildStep title(String title) {
            Objects.requireNonNull(title);
            this.title = title;
            return this;
        }

        /**
         * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
         * This should only be set when referring to an already existing object.
         * @param id id
         * @return Current Builder instance, for fluent method chaining
         * @throws IllegalArgumentException Checks that ID is in the proper format
         */
        public BuildStep id(String id) throws IllegalArgumentException {
            this.id = id;

            try {
                UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
            } catch (Exception exception) {
                throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                        exception);
            }

            return this;
        }
    }


    public final class CopyOfBuilder extends Builder {
        private CopyOfBuilder(String id, String title) {
            super.id(id);
            super.title(title);
        }

        @Override
        public CopyOfBuilder title(String title) {
            return (CopyOfBuilder) super.title(title);
        }
    }

}
