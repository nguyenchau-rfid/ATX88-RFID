package com.atid.app.atx.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atid.app.atx.R;
import com.atid.app.atx.dialog.BaseDialog.ICancelListener;
import com.atid.lib.module.rfid.uhf.types.SelectFlag;
import com.atid.lib.module.rfid.uhf.types.SessionFlag;
import com.atid.lib.module.rfid.uhf.types.SessionTarget;
import com.atid.lib.util.diagnotics.ATLog;

public class InventorySetDialog implements OnClickListener {
	private static final String TAG = InventorySetDialog.class.getSimpleName();
	private static final int INFO = ATLog.L2;
	
	private Context mContext;
	
	private TextView txtSelectFlag;
	private TextView txtSessionTarget;
	private TextView txtSessionFlag;
	
	private EnumListDialog dlgSelectFlag;
	private EnumListDialog dlgSessionTarget;
	private EnumListDialog dlgSessionFlag;
	
	private SelectFlag mSelectFlag;
	private SessionTarget mSessionTarget;
	private SessionFlag mSessionFlag;
	
	public InventorySetDialog() {
		mSelectFlag = SelectFlag.All;
		mSessionTarget = SessionTarget.S0;
		mSessionFlag = SessionFlag.AB;
	}
	
	public SelectFlag getSelectFlag() {
		return mSelectFlag;
	}
	
	public void setSelectFlag(SelectFlag flag) {
		mSelectFlag = flag;
	}
	
	public SessionTarget getSessionTarget() {
		return mSessionTarget;
	}
	
	public void setSessionTarget(SessionTarget target) {
		mSessionTarget = target;
	}
	
	public SessionFlag getSessionFlag() {
		return mSessionFlag;
	}
	
	public void setSessionFlag(SessionFlag flag) {
		mSessionFlag = flag;
	}
	
	public void showDialog(Context context, final IValueChangedListener listener, final ICancelListener cancelListener) {
		
		mContext = context;
		LinearLayout root = (LinearLayout) LinearLayout.inflate(context, R.layout.dialog_inventory_set, null);
		
		txtSelectFlag = (TextView) root.findViewById(R.id.select_flag);
		txtSelectFlag.setOnClickListener(this);
		txtSessionTarget = (TextView) root.findViewById(R.id.session_target);
		txtSessionTarget.setOnClickListener(this);
		txtSessionFlag = (TextView) root.findViewById(R.id.session_flag);
		txtSessionFlag.setOnClickListener(this);
		
		dlgSelectFlag = new EnumListDialog(txtSelectFlag, SelectFlag.values());
		dlgSelectFlag.setValue(mSelectFlag);
		dlgSessionTarget = new EnumListDialog(txtSessionTarget, SessionTarget.values());
		dlgSessionTarget.setValue(mSessionTarget);
		dlgSessionFlag = new EnumListDialog(txtSessionFlag, SessionFlag.values());
		dlgSessionFlag.setValue(mSessionFlag);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(R.string.inventory_set);
		builder.setView(root);
		builder.setPositiveButton(R.string.action_ok, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mSelectFlag = (SelectFlag) dlgSelectFlag.getValue();
				mSessionTarget = (SessionTarget) dlgSessionTarget.getValue();
				mSessionFlag = (SessionFlag) dlgSessionFlag.getValue();
				
				if(listener != null) {
					listener.onValueChanged(InventorySetDialog.this);
				}
			}
		});
		
		builder.setNegativeButton(R.string.action_cancel, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(cancelListener != null) {
					cancelListener.onCanceled(null);
				}
				ATLog.i(TAG, INFO, "INFO. showDialog().$NegativeButton.onClick()");
			}
		});
		
		builder.setCancelable(true);
		builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				if(cancelListener != null) {
					cancelListener.onCanceled(null);
				}
				ATLog.i(TAG, INFO, "INFO. showDialog().onCancel()");
			}
		});
		
		AlertDialog dialog = builder.create();
		dialog.setOnShowListener(new DialogInterface.OnShowListener() {
			
			@Override
			public void onShow(DialogInterface dialog) {
				dlgSelectFlag.display();
				dlgSessionTarget.display();
				dlgSessionFlag.display();
			}
		});
		dialog.show();
		ATLog.i(TAG, INFO, "INFO. showDialog()");
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.select_flag :
			dlgSelectFlag.showDialog(mContext, R.string.select_flag);
			break;
		case R.id.session_target :
			dlgSessionTarget.showDialog(mContext, R.string.session_target);
			break;
		case R.id.session_flag :
			dlgSessionFlag.showDialog(mContext, R.string.session_flag);
			break;
		}
	}
	
	// ------------------------------------------------------------------------
	// Declare Interface IValueChangedListener
	// ------------------------------------------------------------------------

	public interface IValueChangedListener {
		void onValueChanged(InventorySetDialog dialog);
	}
}
