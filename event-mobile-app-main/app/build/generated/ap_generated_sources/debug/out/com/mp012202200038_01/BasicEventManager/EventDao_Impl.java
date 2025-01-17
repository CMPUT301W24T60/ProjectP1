package com.mp012202200038_01.BasicEventManager;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EventDao_Impl implements EventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Event> __insertionAdapterOfEvent;

  private final EntityDeletionOrUpdateAdapter<Event> __updateAdapterOfEvent;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public EventDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEvent = new EntityInsertionAdapter<Event>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `event_table` (`id`,`key`,`title`,`location`,`day`,`month`,`desc`,`time`,`posterUrl`,`qrCodeData`,`isCheckedIn`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Event entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getKey() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getKey());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitle());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocation());
        }
        if (entity.getDay() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDay());
        }
        if (entity.getMonth() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getMonth());
        }
        if (entity.getDesc() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDesc());
        }
        if (entity.getTime() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTime());
        }
        if (entity.getPosterUrl() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPosterUrl());
        }
        if (entity.getQrCodeData() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getQrCodeData());
        }
        final int _tmp = entity.isCheckedIn() ? 1 : 0;
        statement.bindLong(11, _tmp);
      }
    };
    this.__updateAdapterOfEvent = new EntityDeletionOrUpdateAdapter<Event>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `event_table` SET `id` = ?,`key` = ?,`title` = ?,`location` = ?,`day` = ?,`month` = ?,`desc` = ?,`time` = ?,`posterUrl` = ?,`qrCodeData` = ?,`isCheckedIn` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Event entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getKey() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getKey());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTitle());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLocation());
        }
        if (entity.getDay() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDay());
        }
        if (entity.getMonth() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getMonth());
        }
        if (entity.getDesc() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDesc());
        }
        if (entity.getTime() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getTime());
        }
        if (entity.getPosterUrl() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPosterUrl());
        }
        if (entity.getQrCodeData() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getQrCodeData());
        }
        final int _tmp = entity.isCheckedIn() ? 1 : 0;
        statement.bindLong(11, _tmp);
        statement.bindLong(12, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM event_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Event event) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEvent.insert(event);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Event event) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEvent.handle(event);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Event getEventById(final int eventId) {
    final String _sql = "SELECT * FROM event_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, eventId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfPosterUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "posterUrl");
      final int _cursorIndexOfQrCodeData = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodeData");
      final int _cursorIndexOfIsCheckedIn = CursorUtil.getColumnIndexOrThrow(_cursor, "isCheckedIn");
      final Event _result;
      if (_cursor.moveToFirst()) {
        _result = new Event();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpKey;
        if (_cursor.isNull(_cursorIndexOfKey)) {
          _tmpKey = null;
        } else {
          _tmpKey = _cursor.getString(_cursorIndexOfKey);
        }
        _result.setKey(_tmpKey);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _result.setLocation(_tmpLocation);
        final String _tmpDay;
        if (_cursor.isNull(_cursorIndexOfDay)) {
          _tmpDay = null;
        } else {
          _tmpDay = _cursor.getString(_cursorIndexOfDay);
        }
        _result.setDay(_tmpDay);
        final String _tmpMonth;
        if (_cursor.isNull(_cursorIndexOfMonth)) {
          _tmpMonth = null;
        } else {
          _tmpMonth = _cursor.getString(_cursorIndexOfMonth);
        }
        _result.setMonth(_tmpMonth);
        final String _tmpDesc;
        if (_cursor.isNull(_cursorIndexOfDesc)) {
          _tmpDesc = null;
        } else {
          _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
        }
        _result.setDesc(_tmpDesc);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _result.setTime(_tmpTime);
        final String _tmpPosterUrl;
        if (_cursor.isNull(_cursorIndexOfPosterUrl)) {
          _tmpPosterUrl = null;
        } else {
          _tmpPosterUrl = _cursor.getString(_cursorIndexOfPosterUrl);
        }
        _result.setPosterUrl(_tmpPosterUrl);
        final String _tmpQrCodeData;
        if (_cursor.isNull(_cursorIndexOfQrCodeData)) {
          _tmpQrCodeData = null;
        } else {
          _tmpQrCodeData = _cursor.getString(_cursorIndexOfQrCodeData);
        }
        _result.setQrCodeData(_tmpQrCodeData);
        final boolean _tmpIsCheckedIn;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsCheckedIn);
        _tmpIsCheckedIn = _tmp != 0;
        _result.setIsCheckedIn(_tmpIsCheckedIn);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Event>> getAllEvents() {
    final String _sql = "SELECT * FROM event_table ORDER BY day ASC, month ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"event_table"}, false, new Callable<List<Event>>() {
      @Override
      @Nullable
      public List<Event> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "desc");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfPosterUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "posterUrl");
          final int _cursorIndexOfQrCodeData = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCodeData");
          final int _cursorIndexOfIsCheckedIn = CursorUtil.getColumnIndexOrThrow(_cursor, "isCheckedIn");
          final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Event _item;
            _item = new Event();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfKey)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfKey);
            }
            _item.setKey(_tmpKey);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            _item.setTitle(_tmpTitle);
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item.setLocation(_tmpLocation);
            final String _tmpDay;
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _tmpDay = null;
            } else {
              _tmpDay = _cursor.getString(_cursorIndexOfDay);
            }
            _item.setDay(_tmpDay);
            final String _tmpMonth;
            if (_cursor.isNull(_cursorIndexOfMonth)) {
              _tmpMonth = null;
            } else {
              _tmpMonth = _cursor.getString(_cursorIndexOfMonth);
            }
            _item.setMonth(_tmpMonth);
            final String _tmpDesc;
            if (_cursor.isNull(_cursorIndexOfDesc)) {
              _tmpDesc = null;
            } else {
              _tmpDesc = _cursor.getString(_cursorIndexOfDesc);
            }
            _item.setDesc(_tmpDesc);
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            _item.setTime(_tmpTime);
            final String _tmpPosterUrl;
            if (_cursor.isNull(_cursorIndexOfPosterUrl)) {
              _tmpPosterUrl = null;
            } else {
              _tmpPosterUrl = _cursor.getString(_cursorIndexOfPosterUrl);
            }
            _item.setPosterUrl(_tmpPosterUrl);
            final String _tmpQrCodeData;
            if (_cursor.isNull(_cursorIndexOfQrCodeData)) {
              _tmpQrCodeData = null;
            } else {
              _tmpQrCodeData = _cursor.getString(_cursorIndexOfQrCodeData);
            }
            _item.setQrCodeData(_tmpQrCodeData);
            final boolean _tmpIsCheckedIn;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsCheckedIn);
            _tmpIsCheckedIn = _tmp != 0;
            _item.setIsCheckedIn(_tmpIsCheckedIn);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
