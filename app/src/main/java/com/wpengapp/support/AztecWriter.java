package com.wpengapp.support;

/* renamed from: com.wpengapp.support.ޡ */
public final class AztecWriter implements Writer {
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    /* renamed from: ֏ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BitMatrix mo9001(String r7, com.wpengapp.support.BarcodeFormat r8, int r9, int r10, java.util.Map<com.wpengapp.support.EncodeHintType, ?> r11) {
        /*
            r6 = this;
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.ISO_8859_1
            r1 = 33
            if (r11 == 0) goto L_0x0049
            com.wpengapp.support.ޛ r2 = com.wpengapp.support.EncodeHintType.CHARACTER_SET
            boolean r2 = r11.containsKey(r2)
            if (r2 == 0) goto L_0x001c
            com.wpengapp.support.ޛ r0 = com.wpengapp.support.EncodeHintType.CHARACTER_SET
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = r0.toString()
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)
        L_0x001c:
            com.wpengapp.support.ޛ r2 = com.wpengapp.support.EncodeHintType.ERROR_CORRECTION
            boolean r2 = r11.containsKey(r2)
            if (r2 == 0) goto L_0x0032
            com.wpengapp.support.ޛ r1 = com.wpengapp.support.EncodeHintType.ERROR_CORRECTION
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
        L_0x0032:
            com.wpengapp.support.ޛ r2 = com.wpengapp.support.EncodeHintType.AZTEC_LAYERS
            boolean r2 = r11.containsKey(r2)
            if (r2 == 0) goto L_0x0049
            com.wpengapp.support.ޛ r2 = com.wpengapp.support.EncodeHintType.AZTEC_LAYERS
            java.lang.Object r11 = r11.get(r2)
            java.lang.String r11 = r11.toString()
            int r11 = java.lang.Integer.parseInt(r11)
            goto L_0x004a
        L_0x0049:
            r11 = 0
        L_0x004a:
            com.wpengapp.support.ޙ r2 = com.wpengapp.support.BarcodeFormat.AZTEC
            if (r8 != r2) goto L_0x009e
            byte[] r7 = r7.getBytes(r0)
            com.wpengapp.support.ޢ r7 = com.wpengapp.support.C0959.m2562((byte[]) r7, (int) r1, (int) r11)
            com.wpengapp.support.ࢥ r7 = r7.f2661
            if (r7 == 0) goto L_0x0098
            int r8 = r7.f2830
            int r11 = r7.mo9093()
            int r9 = java.lang.Math.max(r9, r8)
            int r10 = java.lang.Math.max(r10, r11)
            int r0 = r9 / r8
            int r1 = r10 / r11
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 2
            int r1 = com.wpengapp.support.outline.m2540(r8, r0, r9, r1)
            r2 = 2
            int r2 = com.wpengapp.support.outline.m2540(r11, r0, r10, r2)
            com.wpengapp.support.ࢥ r3 = new com.wpengapp.support.ࢥ
            r3.<init>(r9, r10)
            r9 = 0
        L_0x0080:
            if (r9 >= r11) goto L_0x0097
            r10 = 0
            r4 = r1
        L_0x0084:
            if (r10 >= r8) goto L_0x0093
            boolean r5 = r7.mo9092(r10, r9)
            if (r5 == 0) goto L_0x008f
            r3.mo9091(r4, r2, r0, r0)
        L_0x008f:
            int r10 = r10 + 1
            int r4 = r4 + r0
            goto L_0x0084
        L_0x0093:
            int r9 = r9 + 1
            int r2 = r2 + r0
            goto L_0x0080
        L_0x0097:
            return r3
        L_0x0098:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x009e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "Can only encode AZTEC, but got "
            java.lang.String r8 = r9.concat(r8)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wpengapp.support.AztecWriter.mo9001(java.lang.String, com.wpengapp.support.ޙ, int, int, java.util.Map):com.wpengapp.support.ࢥ");
    }
}
