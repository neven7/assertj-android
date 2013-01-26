// Copyright 2013 Square, Inc.
package org.fest.assertions.api.android.database;

import android.database.Cursor;
import org.fest.assertions.api.AbstractAssert;

import static org.fest.assertions.api.Assertions.assertThat;

public abstract class AbstractCursorAssert<S extends AbstractCursorAssert<S, A>, A extends Cursor>
    extends AbstractAssert<S, A> {
  public AbstractCursorAssert(A actual, Class<S> selfType) {
    super(actual, selfType);
  }

  public S hasColumnCount(int count) {
    isNotNull();
    int actualCount = actual.getColumnCount();
    assertThat(actualCount) //
        .overridingErrorMessage("Expected column count <%s> but was <%s>.", count, actualCount) //
        .isEqualTo(count);
    return myself;
  }

  public S hasColumn(String columnName) {
    isNotNull();
    if (actual.isBeforeFirst() || actual.isAfterLast()) {
      actual.moveToFirst();
    }
    int actualColumnIndex = actual.getColumnIndex(columnName);
    assertThat(actualColumnIndex) //
        .overridingErrorMessage("Expected to have column <%s> but has not.", columnName) //
        .isNotNegative();
    return myself;
  }

  public S hasCount(int count) {
    isNotNull();
    int actualCount = actual.getCount();
    assertThat(actualCount) //
        .overridingErrorMessage("Expected count <%s> but was <%s>.", count, actualCount) //
        .isEqualTo(count);
    return myself;
  }

  public S hasPosition(int position) {
    isNotNull();
    int actualPosition = actual.getPosition();
    assertThat(actualPosition) //
        .overridingErrorMessage("Expected position <%s> but was <%s>.", position, actualPosition) //
        .isEqualTo(position);
    return myself;
  }

  public S isAfterLast() {
    isNotNull();
    assertThat(actual.isAfterLast()) //
        .overridingErrorMessage("Expected to be after last but was not.") //
        .isTrue();
    return myself;
  }

  public S isNotAfterLast() {
    isNotNull();
    assertThat(actual.isAfterLast()) //
        .overridingErrorMessage("Expected to not be after last but was.") //
        .isFalse();
    return myself;
  }

  public S isBeforeFirst() {
    isNotNull();
    assertThat(actual.isBeforeFirst()) //
        .overridingErrorMessage("Expected to be before first but was not.") //
        .isTrue();
    return myself;
  }

  public S isNotBeforeFrist() {
    isNotNull();
    assertThat(actual.isBeforeFirst()) //
        .overridingErrorMessage("Expected to not be before first but was.") //
        .isFalse();
    return myself;
  }

  public S isClosed() {
    isNotNull();
    assertThat(actual.isClosed()) //
        .overridingErrorMessage("Expected to be closed but was not.") //
        .isTrue();
    return myself;
  }

  public S isNotClosed() {
    isNotNull();
    assertThat(actual.isClosed()) //
        .overridingErrorMessage("Expected to not be closed but was.") //
        .isFalse();
    return myself;
  }

  public S isFirst() {
    isNotNull();
    assertThat(actual.isFirst()) //
        .overridingErrorMessage("Expected to be at first but was not.") //
        .isTrue();
    return myself;
  }

  public S isNotFirst() {
    isNotNull();
    assertThat(actual.isFirst()) //
        .overridingErrorMessage("Expected to not be at first but was.") //
        .isFalse();
    return myself;
  }

  public S isLast() {
    isNotNull();
    assertThat(actual.isLast()) //
        .overridingErrorMessage("Expected to be at last but was not.") //
        .isTrue();
    return myself;
  }

  public S isNotLast() {
    isNotNull();
    assertThat(actual.isLast()) //
        .overridingErrorMessage("Expected to not be at last but was.") //
        .isFalse();
    return myself;
  }
}
