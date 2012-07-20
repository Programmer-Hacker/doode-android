/**************************************************************************
 *  This file is part of the Doode Android project                        *
 *  Copyright (C) 2012 Eduardo Weiland                                    *
 *  duduweiland@users.sourceforge.net                                     *
 *                                                                        *
 *  This program is free software: you can redistribute it and/or modify  *
 *  it under the terms of the GNU General Public License as published by  *
 *  the Free Software Foundation, either version 3 of the License, or     *
 *  (at your option) any later version.                                   *
 *                                                                        *
 *  This program is distributed in the hope that it will be useful,       *
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *  GNU General Public License for more details.                          *
 *                                                                        *
 *  You should have received a copy of the GNU General Public License     *
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>  *
 **************************************************************************/

package net.doode.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity class for posting a new status update.
 *
 * @author Eduardo Weiland
 */
public class UpdateStatusActivity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.update_status );

        ((Button) findViewById( R.id.btnSend )).setOnClickListener( btnSendClick );
    }
    
    public boolean onCreateOptionsMenu( Menu menu ) {
        menu.add("test"); // yep, this is a test

        return super.onCreateOptionsMenu( menu );
    };

    OnClickListener btnSendClick = new OnClickListener() {
        public void onClick(View view) {
            String status = ((EditText) findViewById( R.id.txtStatusMessage )).getText().toString();
            try {
                Doode.client.updateProfileStatus( status );
            }
            catch ( Exception e ) {
                Log.d( "DoodeAndroid", e.getMessage() );
            }
        }
    };

}
