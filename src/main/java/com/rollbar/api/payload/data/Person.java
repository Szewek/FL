package com.rollbar.api.payload.data;

import com.rollbar.api.json.JsonSerializable;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the user affected by an error.
 */
public class Person implements JsonSerializable {

  private final String id;

  private final String username;

  private final String email;

  private Person(Builder builder) {
    this.id = builder.id;
    this.username = builder.username;
    this.email = builder.email;
  }

  /**
   * Getter.
   * @return the id.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Getter.
   * @return the username.
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * Getter.
   * @return the email.
   */
  public String getEmail() {
    return this.email;
  }

  @Override
  public Map<String, Object> asJson() {
    Map<String, Object> values = new HashMap<>();

    if (id != null) {
      values.put("id", id);
    }
    if (username != null) {
      values.put("username", username);
    }
    if (email != null) {
      values.put("email", email);
    }

    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Person person = (Person) o;

    if (id != null ? !id.equals(person.id) : person.id != null) {
      return false;
    }
    if (username != null ? !username.equals(person.username) : person.username != null) {
      return false;
    }
    return email != null ? email.equals(person.email) : person.email == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Person{"
        + "id='" + id + '\''
        + ", username='" + username + '\''
        + ", email='" + email + '\''
        + '}';
  }

  /**
   * Builder class for {@link Person person}.
   */
  public static final class Builder {

    private String id;

    private String username;

    private String email;

    /**
     * Constructor.
     */
    public Builder() {

    }

    /**
     * Constructor.
     *
     * @param person the {@link Person person} to initialize a new builder instance.
     */
    public Builder(Person person) {
      this.id = person.id;
      this.username = person.username;
      this.email = person.email;
    }

    /**
     * The affected user's id.
     *
     * @param id the id.
     * @return the builder instance.
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * The affected user's username.
     *
     * @param username the username.
     * @return the builder instance.
     */
    public Builder username(String username) {
      this.username = username;
      return this;
    }

    /**
     * The affected user's email address.
     *
     * @param email the email.
     * @return the builder instance.
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Builds the {@link Person person}.
     *
     * @return the person.
     */
    public Person build() {
      return new Person(this);
    }
  }
}
