package com.atid.app.atx.dialog;

import java.util.Locale;

import com.atid.app.atx.R;
import com.atid.lib.util.StringUtil;
import com.atid.lib.util.diagnotics.ATLog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;

public class MessageBox {

	private static final String TAG = MessageBox.class.getSimpleName();
	private static final int INFO = ATLog.L2;

	public static void show(Context context, int msgId, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener, int cancelTextId,
			final DialogInterface.OnCancelListener cancelListener) {

		if (msgId == 0) {
			ATLog.e(TAG, "ERROR. show() - Failed to invalid message");
			return;
		}

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (iconId != 0)
			builder.setIcon(iconId);
		if (titleId != 0)
			builder.setTitle(titleId);
		builder.setMessage(msgId);
		if (okTextId == 0)
			okTextId = R.string.action_ok;
		builder.setPositiveButton(okTextId, okListener);
		if (cancelTextId != 0) {
			builder.setNegativeButton(cancelTextId, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					if (cancelListener != null)
						cancelListener.onCancel(dialog);
				}
			});
			builder.setCancelable(true);
			if (cancelListener != null)
				builder.setOnCancelListener(cancelListener);
		} else {
			builder.setCancelable(false);
		}
		builder.show();

		ATLog.i(TAG, INFO, "INFO. show([%s]%s)", context.getResources().getString(msgId),
				titleId == 0 ? "" : String.format(Locale.US, ", [%s]", context.getResources().getString(titleId)));
	}

	public static void show(Context context, int msgId, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener, DialogInterface.OnCancelListener cancelListener) {
		show(context, msgId, titleId, iconId, okTextId, okListener, R.string.action_cancel, cancelListener);
	}

	public static void show(Context context, int msgId, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener, int cancelTextId) {
		show(context, msgId, titleId, iconId, okTextId, okListener, cancelTextId, null);
	}

	public static void show(Context context, int msgId, int titleId, int iconId,
			DialogInterface.OnClickListener okListener, DialogInterface.OnCancelListener cancelListener) {
		show(context, msgId, titleId, iconId, R.string.action_ok, okListener, R.string.action_cancel, cancelListener);
	}

	public static void show(Context context, int msgId, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener) {
		show(context, msgId, titleId, iconId, okTextId, okListener, 0, null);
	}

	public static void show(Context context, int msgId, int titleId, int iconId,
			DialogInterface.OnClickListener okListener, int cancelTextId) {
		show(context, msgId, titleId, iconId, R.string.action_ok, okListener, cancelTextId, null);
	}

	public static void show(Context context, int msgId, int titleId, int iconId,
			DialogInterface.OnClickListener okListener) {
		show(context, msgId, titleId, iconId, R.string.action_ok, okListener, 0, null);
	}

	public static void show(Context context, int msgId, int titleId, int iconId) {
		show(context, msgId, titleId, iconId, R.string.action_ok, null, 0, null);
	}

	public static void show(Context context, int msgId, int titleId) {
		show(context, msgId, titleId, 0, R.string.action_ok, null, 0, null);
	}

	public static void show(Context context, int msgId) {
		show(context, msgId, 0, 0, R.string.action_ok, null, 0, null);
	}

	public static void show(Context context, String msg, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener, int cancelTextId,
			final DialogInterface.OnCancelListener cancelListener) {

		if (StringUtil.isNullOrEmpty(msg)) {
			ATLog.e(TAG, "ERROR. show() - Failed to invalid message");
			return;
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (iconId != 0)
			builder.setIcon(iconId);
		if (titleId != 0)
			builder.setTitle(titleId);
		builder.setMessage(msg);
		if (okTextId == 0)
			okTextId = R.string.action_ok;
		builder.setPositiveButton(okTextId, okListener);
		if (cancelTextId != 0) {
			builder.setNegativeButton(cancelTextId, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					if (cancelListener != null)
						cancelListener.onCancel(dialog);
				}
			});
			builder.setCancelable(true);
			if (cancelListener != null)
				builder.setOnCancelListener(cancelListener);
		} else {
			builder.setCancelable(false);
		}
		builder.show();

		ATLog.i(TAG, INFO, "INFO. show([%s]%s)", msg,
				titleId == 0 ? "" : String.format(Locale.US, ", [%s]", context.getResources().getString(titleId)));
	}

	public static void show(Context context, String msg, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener, DialogInterface.OnCancelListener cancelListener) {
		show(context, msg, titleId, iconId, okTextId, okListener, R.string.action_cancel, cancelListener);
	}

	public static void show(Context context, String msg, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener, int cancelTextId) {
		show(context, msg, titleId, iconId, okTextId, okListener, cancelTextId, null);
	}

	public static void show(Context context, String msg, int titleId, int iconId,
			DialogInterface.OnClickListener okListener, DialogInterface.OnCancelListener cancelListener) {
		show(context, msg, titleId, iconId, R.string.action_ok, okListener, R.string.action_cancel, cancelListener);
	}

	public static void show(Context context, String msg, int titleId, int iconId, int okTextId,
			DialogInterface.OnClickListener okListener) {
		show(context, msg, titleId, iconId, okTextId, okListener, 0, null);
	}

	public static void show(Context context, String msg, int titleId, int iconId,
			DialogInterface.OnClickListener okListener, int cancelTextId) {
		show(context, msg, titleId, iconId, R.string.action_ok, okListener, cancelTextId, null);
	}

	public static void show(Context context, String msg, int titleId, int iconId,
			DialogInterface.OnClickListener okListener) {
		show(context, msg, titleId, iconId, R.string.action_ok, okListener, 0, null);
	}

	public static void show(Context context, String msg, int titleId, int iconId) {
		show(context, msg, titleId, iconId, R.string.action_ok, null, 0, null);
	}

	public static void show(Context context, String msg, int titleId) {
		show(context, msg, titleId, 0, R.string.action_ok, null, 0, null);
	}

	public static void show(Context context, String msg, String title, Drawable icon, String okText,
			DialogInterface.OnClickListener okListener, String cancelText,
			final DialogInterface.OnCancelListener cancelListener) {

		if (StringUtil.isNullOrEmpty(msg)) {
			ATLog.e(TAG, "ERROR. show() - Failed to invalid message");
			return;
		}

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		if (icon != null)
			builder.setIcon(icon);
		if (!StringUtil.isNullOrEmpty(title))
			builder.setTitle(title);
		builder.setMessage(msg);
		if (StringUtil.isNullOrEmpty(okText))
			okText = context.getResources().getString(R.string.action_ok);
		builder.setPositiveButton(okText, okListener);
		if (!StringUtil.isNullOrEmpty(cancelText)) {
			builder.setNegativeButton(cancelText, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					if (cancelListener != null)
						cancelListener.onCancel(dialog);
				}
			});
			builder.setCancelable(true);
			if (cancelListener != null)
				builder.setOnCancelListener(cancelListener);
		} else {
			builder.setCancelable(false);
		}
		builder.show();

		ATLog.i(TAG, INFO, "INFO. show([%s]%s)", msg,
				StringUtil.isNullOrEmpty(title) ? "" : String.format(Locale.US, ", [%s]", title));
	}

	public static void show(Context context, String msg, String title, Drawable icon, String okText,
			DialogInterface.OnClickListener okListener, final DialogInterface.OnCancelListener cancelListener) {
		show(context, msg, title, icon, okText, okListener, context.getResources().getString(R.string.action_cancel),
				cancelListener);
	}

	public static void show(Context context, String msg, String title, Drawable icon, String okText,
			DialogInterface.OnClickListener okListener, String cancelText) {
		show(context, msg, title, icon, okText, okListener, cancelText, null);
	}

	public static void show(Context context, String msg, String title, Drawable icon,
			DialogInterface.OnClickListener okListener, DialogInterface.OnCancelListener cancelListener) {
		show(context, msg, title, icon, context.getResources().getString(R.string.action_ok), okListener,
				context.getResources().getString(R.string.action_cancel), cancelListener);
	}

	public static void show(Context context, String msg, String title, Drawable icon, String okText,
			DialogInterface.OnClickListener okListener) {
		show(context, msg, title, icon, okText, okListener, "", null);
	}

	public static void show(Context context, String msg, String title, Drawable icon,
			DialogInterface.OnClickListener okListener, String cancelTextId) {
		show(context, msg, title, icon, context.getResources().getString(R.string.action_ok), okListener, cancelTextId, null);
	}

	public static void show(Context context, String msg, String title, Drawable icon,
			DialogInterface.OnClickListener okListener) {
		show(context, msg, title, icon, context.getResources().getString(R.string.action_ok), okListener, "", null);
	}

	public static void show(Context context, String msg, String title, Drawable icon) {
		show(context, msg, title, icon, context.getResources().getString(R.string.action_ok), null, "", null);
	}

	public static void show(Context context, String msg, String title) {
		show(context, msg, title, null, context.getResources().getString(R.string.action_ok), null, "", null);
	}

	public static void show(Context context, String msg) {
		show(context, msg, "", null, context.getResources().getString(R.string.action_ok), null, "", null);
	}
}
