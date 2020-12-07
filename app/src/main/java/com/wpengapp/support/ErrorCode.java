package com.wpengapp.support;

import android.support.p000v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.wpengapp.http.R$string;

/* renamed from: com.wpengapp.support.ȓ */
public enum ErrorCode {
    MAINTAIN(-2, WPengServer.m1071(R$string.error_maintain)),
    FAILED(-1, WPengServer.m1071(R$string.error_failed)),
    SUCCESS(0, WPengServer.m1071(R$string.error_success)),
    EXCEPTION(1, WPengServer.m1071(R$string.error_exception)),
    INVALID_SIGNATURE(2, WPengServer.m1071(R$string.error_signature_invalid)),
    SUCCESS_WITH_MSG(3, WPengServer.m1071(R$string.error_success)),
    FAILED_WITH_MSG(4, WPengServer.m1071(R$string.error_failed)),
    APP_CODE_INVALID(5, WPengServer.m1071(R$string.error_invalid_app_code)),
    APP_CODE_USED(6, WPengServer.m1071(R$string.error_app_code_used)),
    APP_CODE_LIMIT(7, WPengServer.m1071(R$string.error_app_code_limit)),
    APP_CODE_DISABLE(8, WPengServer.m1071(R$string.error_app_code_disabled)),
    APP_ORDER_ALREADY_PAID(11, "Order already paid"),
    REQUEST_FREQUENT(12, WPengServer.m1071(R$string.error_request_frequent)),
    USER_CONTACT_NO_PAY_RECORD(PointerIconCompat.TYPE_CONTEXT_MENU, WPengServer.m1071(R$string.error_user_contact_no_pay_record)),
    USER_DEVICE_NO_PAY_RECORD(PointerIconCompat.TYPE_HAND, WPengServer.m1071(R$string.error_user_device_no_pay_record)),
    USER_LOCAL_ID_INVALID(PointerIconCompat.TYPE_HELP, WPengServer.m1071(R$string.error_user_local_id_invalid)),
    USER_ALREADY_PAID(PointerIconCompat.TYPE_WAIT, "User already paid"),
    USER_CHANGE_BIND_OVER_LIMIT(1005, WPengServer.m1071(R$string.error_user_change_bind_over_limit)),
    USER_CONTACT_ERROR(PointerIconCompat.TYPE_CELL, WPengServer.m1071(R$string.error_user_contact_error)),
    USER_SEND_CODE_ERROR(PointerIconCompat.TYPE_CROSSHAIR, WPengServer.m1071(R$string.error_user_send_code_error)),
    USER_VERIFY_CODE_ERROR(PointerIconCompat.TYPE_TEXT, WPengServer.m1071(R$string.error_user_verify_code_error)),
    USER_NOT_FOUND(PointerIconCompat.TYPE_VERTICAL_TEXT, WPengServer.m1071(R$string.error_user_not_found)),
    USER_ALREADY_CAN_CHANGE_DEVICE(PointerIconCompat.TYPE_ALIAS, WPengServer.m1071(R$string.error_user_already_can_change_device)),
    USER_UPGRADE_DISABLE(PointerIconCompat.TYPE_COPY, WPengServer.m1071(R$string.error_user_upgrade_disable)),
    USER_FULL_PAY_DISABLE(PointerIconCompat.TYPE_NO_DROP, WPengServer.m1071(R$string.error_not_support)),
    SKAD_CONFIG_NO_UPDATE(10001, "Config no update");
    

    /* renamed from: ޙ */
    public final int f1082;

    /* renamed from: ޚ */
    public String f1083;

    /* access modifiers changed from: public */
    ErrorCode(int i, String str) {
        this.f1082 = i;
        this.f1083 = str;
    }

    /* renamed from: ֏ */
    public static void m1335(HttpResponse r1, ErrorCode r2) {
        if (!TextUtils.isEmpty(r1.f3516)) {
            r2.f1083 = r1.f3516;
            WPengServer.m1074(r2.f1083);
        }
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("ErrorCode{code=");
        r0.append(this.f1082);
        r0.append(", message='");
        r0.append(this.f1083);
        r0.append('\'');
        r0.append('}');
        return r0.toString();
    }

    /* renamed from: ؠ */
    public boolean mo8157() {
        return this == SUCCESS || this == SUCCESS_WITH_MSG;
    }

    /* renamed from: ֏ */
    public static boolean m1336(ErrorCode r1) {
        return r1 == SUCCESS || r1 == SUCCESS_WITH_MSG;
    }

    /* renamed from: ֏ */
    public boolean mo8156() {
        return !m1336(this);
    }
}
