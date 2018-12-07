package com.luchongbin.mycashbook.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.luchongbin.mycashbook.bean.CashBook;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CASH_BOOK".
*/
public class CashBookDao extends AbstractDao<CashBook, Long> {

    public static final String TABLENAME = "CASH_BOOK";

    /**
     * Properties of entity CashBook.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CashBookId = new Property(1, long.class, "cashBookId", false, "CASH_BOOK_ID");
        public final static Property UserId = new Property(2, long.class, "userId", false, "USER_ID");
        public final static Property DigFlatHour = new Property(3, double.class, "digFlatHour", false, "DIG_FLAT_HOUR");
        public final static Property DigFlatTotalAmount = new Property(4, double.class, "digFlatTotalAmount", false, "DIG_FLAT_TOTAL_AMOUNT");
        public final static Property FractureHour = new Property(5, double.class, "fractureHour", false, "FRACTURE_HOUR");
        public final static Property FractureTotalAmount = new Property(6, double.class, "fractureTotalAmount", false, "FRACTURE_TOTAL_AMOUNT");
        public final static Property Date = new Property(7, String.class, "date", false, "DATE");
        public final static Property Remarks = new Property(8, String.class, "remarks", false, "REMARKS");
        public final static Property Autograph = new Property(9, String.class, "autograph", false, "AUTOGRAPH");
    }


    public CashBookDao(DaoConfig config) {
        super(config);
    }
    
    public CashBookDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CASH_BOOK\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CASH_BOOK_ID\" INTEGER NOT NULL ," + // 1: cashBookId
                "\"USER_ID\" INTEGER NOT NULL ," + // 2: userId
                "\"DIG_FLAT_HOUR\" REAL NOT NULL ," + // 3: digFlatHour
                "\"DIG_FLAT_TOTAL_AMOUNT\" REAL NOT NULL ," + // 4: digFlatTotalAmount
                "\"FRACTURE_HOUR\" REAL NOT NULL ," + // 5: fractureHour
                "\"FRACTURE_TOTAL_AMOUNT\" REAL NOT NULL ," + // 6: fractureTotalAmount
                "\"DATE\" TEXT," + // 7: date
                "\"REMARKS\" TEXT," + // 8: remarks
                "\"AUTOGRAPH\" TEXT);"); // 9: autograph
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CASH_BOOK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CashBook entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCashBookId());
        stmt.bindLong(3, entity.getUserId());
        stmt.bindDouble(4, entity.getDigFlatHour());
        stmt.bindDouble(5, entity.getDigFlatTotalAmount());
        stmt.bindDouble(6, entity.getFractureHour());
        stmt.bindDouble(7, entity.getFractureTotalAmount());
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(8, date);
        }
 
        String remarks = entity.getRemarks();
        if (remarks != null) {
            stmt.bindString(9, remarks);
        }
 
        String autograph = entity.getAutograph();
        if (autograph != null) {
            stmt.bindString(10, autograph);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CashBook entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCashBookId());
        stmt.bindLong(3, entity.getUserId());
        stmt.bindDouble(4, entity.getDigFlatHour());
        stmt.bindDouble(5, entity.getDigFlatTotalAmount());
        stmt.bindDouble(6, entity.getFractureHour());
        stmt.bindDouble(7, entity.getFractureTotalAmount());
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(8, date);
        }
 
        String remarks = entity.getRemarks();
        if (remarks != null) {
            stmt.bindString(9, remarks);
        }
 
        String autograph = entity.getAutograph();
        if (autograph != null) {
            stmt.bindString(10, autograph);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public CashBook readEntity(Cursor cursor, int offset) {
        CashBook entity = new CashBook( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // cashBookId
            cursor.getLong(offset + 2), // userId
            cursor.getDouble(offset + 3), // digFlatHour
            cursor.getDouble(offset + 4), // digFlatTotalAmount
            cursor.getDouble(offset + 5), // fractureHour
            cursor.getDouble(offset + 6), // fractureTotalAmount
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // date
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // remarks
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // autograph
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CashBook entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCashBookId(cursor.getLong(offset + 1));
        entity.setUserId(cursor.getLong(offset + 2));
        entity.setDigFlatHour(cursor.getDouble(offset + 3));
        entity.setDigFlatTotalAmount(cursor.getDouble(offset + 4));
        entity.setFractureHour(cursor.getDouble(offset + 5));
        entity.setFractureTotalAmount(cursor.getDouble(offset + 6));
        entity.setDate(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setRemarks(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAutograph(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CashBook entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CashBook entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CashBook entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}