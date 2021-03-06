package com.luchongbin.mycashbook.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.luchongbin.mycashbook.bean.CheQueLog;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CHE_QUE_LOG".
*/
public class CheQueLogDao extends AbstractDao<CheQueLog, Long> {

    public static final String TABLENAME = "CHE_QUE_LOG";

    /**
     * Properties of entity CheQueLog.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CashBookId = new Property(1, long.class, "cashBookId", false, "CASH_BOOK_ID");
        public final static Property Amount = new Property(2, double.class, "amount", false, "AMOUNT");
    }


    public CheQueLogDao(DaoConfig config) {
        super(config);
    }
    
    public CheQueLogDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CHE_QUE_LOG\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CASH_BOOK_ID\" INTEGER NOT NULL ," + // 1: cashBookId
                "\"AMOUNT\" REAL NOT NULL );"); // 2: amount
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CHE_QUE_LOG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CheQueLog entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCashBookId());
        stmt.bindDouble(3, entity.getAmount());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CheQueLog entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCashBookId());
        stmt.bindDouble(3, entity.getAmount());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CheQueLog readEntity(Cursor cursor, int offset) {
        CheQueLog entity = new CheQueLog( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // cashBookId
            cursor.getDouble(offset + 2) // amount
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CheQueLog entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCashBookId(cursor.getLong(offset + 1));
        entity.setAmount(cursor.getDouble(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CheQueLog entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CheQueLog entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CheQueLog entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
