/*
 * ASTRID: Android's Simple Task Recording Dashboard
 *
 * Copyright (c) 2009 Tim Su
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.timsu.astrid.data.task;

import java.util.Date;

import android.content.ContentValues;
import android.database.Cursor;

import com.timsu.astrid.data.AbstractController;



/** Fields that you would want to edit pertaining to repeats */
public class TaskModelForRepeat extends AbstractTaskModel {

    static String[] FIELD_LIST = new String[] {
        AbstractController.KEY_ROWID,
        REPEAT,
        DEFINITE_DUE_DATE,
        PREFERRED_DUE_DATE,
        HIDDEN_UNTIL,
        PROGRESS_PERCENTAGE,
    };

    public void repeatTaskBy(RepeatInfo repeatInfo) {
        if(getDefiniteDueDate() != null)
            setDefiniteDueDate(repeatInfo.shiftDate(getDefiniteDueDate()));
        if(getHiddenUntil() != null)
            setHiddenUntil(repeatInfo.shiftDate(getHiddenUntil()));
        if(getPreferredDueDate() != null)
            setPreferredDueDate(repeatInfo.shiftDate(getPreferredDueDate()));
        setProgressPercentage(0);

        // TODO shift fixed alerts?
    }

    // --- constructors

    public TaskModelForRepeat(Cursor cursor, ContentValues setValues) {
        super(cursor);
        this.setValues = setValues;
    }

    // --- getters and setters

    @Override
    public RepeatInfo getRepeat() {
        return super.getRepeat();
    }

    @Override
    public void setDefiniteDueDate(Date definiteDueDate) {
        super.setDefiniteDueDate(definiteDueDate);
    }

    @Override
    public void setPreferredDueDate(Date preferredDueDate) {
        super.setPreferredDueDate(preferredDueDate);
    }

    @Override
    public void setHiddenUntil(Date hiddenUntil) {
        super.setHiddenUntil(hiddenUntil);
    }
}
