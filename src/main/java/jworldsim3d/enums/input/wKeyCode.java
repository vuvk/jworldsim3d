package jworldsim3d.enums.input;

/**
 *
 * @author Vuvk
 */
public interface wKeyCode {
    /** <i>native declaration : line 42</i> */
    public static final int wKC_UNKNOWN = 0x0;
    /**
     * Left mouse button<br>
     * <i>native declaration : line 44</i>
     */
    public static final int wKC_LBUTTON = 0x01;
    /**
     * Right mouse button<br>
     * <i>native declaration : line 46</i>
     */
    public static final int wKC_RBUTTON = 0x02;
    /**
     * Control-break processing<br>
     * <i>native declaration : line 48</i>
     */
    public static final int wKC_CANCEL = 0x03;
    /**
     * Middle mouse button (three-button mouse)<br>
     * <i>native declaration : line 50</i>
     */
    public static final int wKC_MBUTTON = 0x04;
    /**
     * Windows 2000/XP: X1 mouse button<br>
     * <i>native declaration : line 52</i>
     */
    public static final int wKC_XBUTTON1 = 0x05;
    /**
     * Windows 2000/XP: X2 mouse button<br>
     * <i>native declaration : line 54</i>
     */
    public static final int wKC_XBUTTON2 = 0x06;
    /**
     * BACKSPACE key<br>
     * <i>native declaration : line 56</i>
     */
    public static final int wKC_BACK = 0x08;
    /**
     * TAB key<br>
     * <i>native declaration : line 58</i>
     */
    public static final int wKC_TAB = 0x09;
    /**
     * CLEAR key<br>
     * <i>native declaration : line 60</i>
     */
    public static final int wKC_CLEAR = 0x0C;
    /**
     * ENTER key<br>
     * <i>native declaration : line 62</i>
     */
    public static final int wKC_RETURN = 0x0D;
    /**
     * SHIFT key<br>
     * <i>native declaration : line 64</i>
     */
    public static final int wKC_SHIFT = 0x10;
    /**
     * CTRL key<br>
     * <i>native declaration : line 66</i>
     */
    public static final int wKC_CONTROL = 0x11;
    /**
     * ALT key<br>
     * <i>native declaration : line 68</i>
     */
    public static final int wKC_MENU = 0x12;
    /**
     * PAUSE key<br>
     * <i>native declaration : line 70</i>
     */
    public static final int wKC_PAUSE = 0x13;
    /**
     * CAPS LOCK key<br>
     * <i>native declaration : line 72</i>
     */
    public static final int wKC_CAPITAL = 0x14;
    /**
     * IME Kana mode<br>
     * <i>native declaration : line 74</i>
     */
    public static final int wKC_KANA = 0x15;
    /**
     * IME Hanguel mode (maintained for compatibility use KEY_HANGUL)<br>
     * <i>native declaration : line 76</i>
     */
    public static final int wKC_HANGUEL = 0x15;
    /**
     * IME Hangul mode<br>
     * <i>native declaration : line 78</i>
     */
    public static final int wKC_HANGUL = 0x15;
    /**
     * IME Junja mode<br>
     * <i>native declaration : line 80</i>
     */
    public static final int wKC_JUNJA = 0x17;
    /**
     * IME final mode<br>
     * <i>native declaration : line 82</i>
     */
    public static final int wKC_FINAL = 0x18;
    /**
     * IME Hanja mode<br>
     * <i>native declaration : line 84</i>
     */
    public static final int wKC_HANJA = 0x19;
    /**
     * IME Kanji mode<br>
     * <i>native declaration : line 86</i>
     */
    public static final int wKC_KANJI = 0x19;
    /**
     * ESC key<br>
     * <i>native declaration : line 88</i>
     */
    public static final int wKC_ESCAPE = 0x1B;
    /**
     * IME convert<br>
     * <i>native declaration : line 90</i>
     */
    public static final int wKC_CONVERT = 0x1C;
    /**
     * IME nonconvert<br>
     * <i>native declaration : line 92</i>
     */
    public static final int wKC_NONCONVERT = 0x1D;
    /**
     * IME accept<br>
     * <i>native declaration : line 94</i>
     */
    public static final int wKC_ACCEPT = 0x1E;
    /**
     * IME mode change request<br>
     * <i>native declaration : line 96</i>
     */
    public static final int wKC_MODECHANGE = 0x1F;
    /**
     * SPACEBAR<br>
     * <i>native declaration : line 98</i>
     */
    public static final int wKC_SPACE = 0x20;
    /**
     * PAGE UP key<br>
     * <i>native declaration : line 100</i>
     */
    public static final int wKC_PRIOR = 0x21;
    /**
     * PAGE DOWN key<br>
     * <i>native declaration : line 102</i>
     */
    public static final int wKC_NEXT = 0x22;
    /**
     * END key<br>
     * <i>native declaration : line 104</i>
     */
    public static final int wKC_END = 0x23;
    /**
     * HOME key<br>
     * <i>native declaration : line 106</i>
     */
    public static final int wKC_HOME = 0x24;
    /**
     * LEFT ARROW key<br>
     * <i>native declaration : line 108</i>
     */
    public static final int wKC_LEFT = 0x25;
    /**
     * UP ARROW key<br>
     * <i>native declaration : line 110</i>
     */
    public static final int wKC_UP = 0x26;
    /**
     * RIGHT ARROW key<br>
     * <i>native declaration : line 112</i>
     */
    public static final int wKC_RIGHT = 0x27;
    /**
     * DOWN ARROW key<br>
     * <i>native declaration : line 114</i>
     */
    public static final int wKC_DOWN = 0x28;
    /**
     * SELECT key<br>
     * <i>native declaration : line 116</i>
     */
    public static final int wKC_SELECT = 0x29;
    /**
     * PRINT key<br>
     * <i>native declaration : line 118</i>
     */
    public static final int wKC_PRINT = 0x2A;
    /**
     * EXECUTE key<br>
     * <i>native declaration : line 120</i>
     */
    public static final int wKC_EXECUT = 0x2B;
    /**
     * PRINT SCREEN key<br>
     * <i>native declaration : line 122</i>
     */
    public static final int wKC_SNAPSHOT = 0x2C;
    /**
     * INS key<br>
     * <i>native declaration : line 124</i>
     */
    public static final int wKC_INSERT = 0x2D;
    /**
     * DEL key<br>
     * <i>native declaration : line 126</i>
     */
    public static final int wKC_DELETE = 0x2E;
    /**
     * HELP key<br>
     * <i>native declaration : line 128</i>
     */
    public static final int wKC_HELP = 0x2F;
    /**
     * 0 key<br>
     * <i>native declaration : line 130</i>
     */
    public static final int wKC_KEY_0 = 0x30;
    /**
     * 1 key<br>
     * <i>native declaration : line 132</i>
     */
    public static final int wKC_KEY_1 = 0x31;
    /**
     * 2 key<br>
     * <i>native declaration : line 134</i>
     */
    public static final int wKC_KEY_2 = 0x32;
    /**
     * 3 key<br>
     * <i>native declaration : line 136</i>
     */
    public static final int wKC_KEY_3 = 0x33;
    /**
     * 4 key<br>
     * <i>native declaration : line 138</i>
     */
    public static final int wKC_KEY_4 = 0x34;
    /**
     * 5 key<br>
     * <i>native declaration : line 140</i>
     */
    public static final int wKC_KEY_5 = 0x35;
    /**
     * 6 key<br>
     * <i>native declaration : line 142</i>
     */
    public static final int wKC_KEY_6 = 0x36;
    /**
     * 7 key<br>
     * <i>native declaration : line 144</i>
     */
    public static final int wKC_KEY_7 = 0x37;
    /**
     * 8 key<br>
     * <i>native declaration : line 146</i>
     */
    public static final int wKC_KEY_8 = 0x38;
    /**
     * 9 key<br>
     * <i>native declaration : line 148</i>
     */
    public static final int wKC_KEY_9 = 0x39;
    /**
     * A key<br>
     * <i>native declaration : line 150</i>
     */
    public static final int wKC_KEY_A = 0x41;
    /**
     * B key<br>
     * <i>native declaration : line 152</i>
     */
    public static final int wKC_KEY_B = 0x42;
    /**
     * C key<br>
     * <i>native declaration : line 154</i>
     */
    public static final int wKC_KEY_C = 0x43;
    /**
     * D key<br>
     * <i>native declaration : line 156</i>
     */
    public static final int wKC_KEY_D = 0x44;
    /**
     * E key<br>
     * <i>native declaration : line 158</i>
     */
    public static final int wKC_KEY_E = 0x45;
    /**
     * F key<br>
     * <i>native declaration : line 160</i>
     */
    public static final int wKC_KEY_F = 0x46;
    /**
     * G key<br>
     * <i>native declaration : line 162</i>
     */
    public static final int wKC_KEY_G = 0x47;
    /**
     * H key<br>
     * <i>native declaration : line 164</i>
     */
    public static final int wKC_KEY_H = 0x48;
    /**
     * I key<br>
     * <i>native declaration : line 166</i>
     */
    public static final int wKC_KEY_I = 0x49;
    /**
     * J key<br>
     * <i>native declaration : line 168</i>
     */
    public static final int wKC_KEY_J = 0x4A;
    /**
     * K key<br>
     * <i>native declaration : line 170</i>
     */
    public static final int wKC_KEY_K = 0x4B;
    /**
     * L key<br>
     * <i>native declaration : line 172</i>
     */
    public static final int wKC_KEY_L = 0x4C;
    /**
     * M key<br>
     * <i>native declaration : line 174</i>
     */
    public static final int wKC_KEY_M = 0x4D;
    /**
     * N key<br>
     * <i>native declaration : line 176</i>
     */
    public static final int wKC_KEY_N = 0x4E;
    /**
     * O key<br>
     * <i>native declaration : line 178</i>
     */
    public static final int wKC_KEY_O = 0x4F;
    /**
     * P key<br>
     * <i>native declaration : line 180</i>
     */
    public static final int wKC_KEY_P = 0x50;
    /**
     * Q key<br>
     * <i>native declaration : line 182</i>
     */
    public static final int wKC_KEY_Q = 0x51;
    /**
     * R key<br>
     * <i>native declaration : line 184</i>
     */
    public static final int wKC_KEY_R = 0x52;
    /**
     * S key<br>
     * <i>native declaration : line 186</i>
     */
    public static final int wKC_KEY_S = 0x53;
    /**
     * T key<br>
     * <i>native declaration : line 188</i>
     */
    public static final int wKC_KEY_T = 0x54;
    /**
     * U key<br>
     * <i>native declaration : line 190</i>
     */
    public static final int wKC_KEY_U = 0x55;
    /**
     * V key<br>
     * <i>native declaration : line 192</i>
     */
    public static final int wKC_KEY_V = 0x56;
    /**
     * W key<br>
     * <i>native declaration : line 194</i>
     */
    public static final int wKC_KEY_W = 0x57;
    /**
     * X key<br>
     * <i>native declaration : line 196</i>
     */
    public static final int wKC_KEY_X = 0x58;
    /**
     * Y key<br>
     * <i>native declaration : line 198</i>
     */
    public static final int wKC_KEY_Y = 0x59;
    /**
     * Z key<br>
     * <i>native declaration : line 200</i>
     */
    public static final int wKC_KEY_Z = 0x5A;
    /**
     * Left Windows key (Microsoft\u00ae Natural\u00ae keyboard)<br>
     * <i>native declaration : line 202</i>
     */
    public static final int wKC_LWIN = 0x5B;
    /**
     * Right Windows key (Natural keyboard)<br>
     * <i>native declaration : line 204</i>
     */
    public static final int wKC_RWIN = 0x5C;
    /**
     * Applications key (Natural keyboard)<br>
     * <i>native declaration : line 206</i>
     */
    public static final int wKC_APPS = 0x5D;
    /**
     * Computer Sleep key<br>
     * <i>native declaration : line 208</i>
     */
    public static final int wKC_SLEEP = 0x5F;
    /**
     * Numeric keypad 0 key<br>
     * <i>native declaration : line 210</i>
     */
    public static final int wKC_NUMPAD0 = 0x60;
    /**
     * Numeric keypad 1 key<br>
     * <i>native declaration : line 212</i>
     */
    public static final int wKC_NUMPAD1 = 0x61;
    /**
     * Numeric keypad 2 key<br>
     * <i>native declaration : line 214</i>
     */
    public static final int wKC_NUMPAD2 = 0x62;
    /**
     * Numeric keypad 3 key<br>
     * <i>native declaration : line 216</i>
     */
    public static final int wKC_NUMPAD3 = 0x63;
    /**
     * Numeric keypad 4 key<br>
     * <i>native declaration : line 218</i>
     */
    public static final int wKC_NUMPAD4 = 0x64;
    /**
     * Numeric keypad 5 key<br>
     * <i>native declaration : line 220</i>
     */
    public static final int wKC_NUMPAD5 = 0x65;
    /**
     * Numeric keypad 6 key<br>
     * <i>native declaration : line 222</i>
     */
    public static final int wKC_NUMPAD6 = 0x66;
    /**
     * Numeric keypad 7 key<br>
     * <i>native declaration : line 224</i>
     */
    public static final int wKC_NUMPAD7 = 0x67;
    /**
     * Numeric keypad 8 key<br>
     * <i>native declaration : line 226</i>
     */
    public static final int wKC_NUMPAD8 = 0x68;
    /**
     * Numeric keypad 9 key<br>
     * <i>native declaration : line 228</i>
     */
    public static final int wKC_NUMPAD9 = 0x69;
    /**
     * Multiply key<br>
     * <i>native declaration : line 230</i>
     */
    public static final int wKC_MULTIPLY = 0x6A;
    /**
     * Add key<br>
     * <i>native declaration : line 232</i>
     */
    public static final int wKC_ADD = 0x6B;
    /**
     * Separator key<br>
     * <i>native declaration : line 234</i>
     */
    public static final int wKC_SEPARATOR = 0x6C;
    /**
     * Subtract key<br>
     * <i>native declaration : line 236</i>
     */
    public static final int wKC_SUBTRACT = 0x6D;
    /**
     * Decimal key<br>
     * <i>native declaration : line 238</i>
     */
    public static final int wKC_DECIMAL = 0x6E;
    /**
     * Divide key<br>
     * <i>native declaration : line 240</i>
     */
    public static final int wKC_DIVIDE = 0x6F;
    /**
     * F1 key<br>
     * <i>native declaration : line 242</i>
     */
    public static final int wKC_F1 = 0x70;
    /**
     * F2 key<br>
     * <i>native declaration : line 244</i>
     */
    public static final int wKC_F2 = 0x71;
    /**
     * F3 key<br>
     * <i>native declaration : line 246</i>
     */
    public static final int wKC_F3 = 0x72;
    /**
     * F4 key<br>
     * <i>native declaration : line 248</i>
     */
    public static final int wKC_F4 = 0x73;
    /**
     * F5 key<br>
     * <i>native declaration : line 250</i>
     */
    public static final int wKC_F5 = 0x74;
    /**
     * F6 key<br>
     * <i>native declaration : line 252</i>
     */
    public static final int wKC_F6 = 0x75;
    /**
     * F7 key<br>
     * <i>native declaration : line 254</i>
     */
    public static final int wKC_F7 = 0x76;
    /**
     * F8 key<br>
     * <i>native declaration : line 256</i>
     */
    public static final int wKC_F8 = 0x77;
    /**
     * F9 key<br>
     * <i>native declaration : line 258</i>
     */
    public static final int wKC_F9 = 0x78;
    /**
     * F10 key<br>
     * <i>native declaration : line 260</i>
     */
    public static final int wKC_F10 = 0x79;
    /**
     * F11 key<br>
     * <i>native declaration : line 262</i>
     */
    public static final int wKC_F11 = 0x7A;
    /**
     * F12 key<br>
     * <i>native declaration : line 264</i>
     */
    public static final int wKC_F12 = 0x7B;
    /**
     * F13 key<br>
     * <i>native declaration : line 266</i>
     */
    public static final int wKC_F13 = 0x7C;
    /**
     * F14 key<br>
     * <i>native declaration : line 268</i>
     */
    public static final int wKC_F14 = 0x7D;
    /**
     * F15 key<br>
     * <i>native declaration : line 270</i>
     */
    public static final int wKC_F15 = 0x7E;
    /**
     * F16 key<br>
     * <i>native declaration : line 272</i>
     */
    public static final int wKC_F16 = 0x7F;
    /**
     * F17 key<br>
     * <i>native declaration : line 274</i>
     */
    public static final int wKC_F17 = 0x80;
    /**
     * F18 key<br>
     * <i>native declaration : line 276</i>
     */
    public static final int wKC_F18 = 0x81;
    /**
     * F19 key<br>
     * <i>native declaration : line 278</i>
     */
    public static final int wKC_F19 = 0x82;
    /**
     * F20 key<br>
     * <i>native declaration : line 280</i>
     */
    public static final int wKC_F20 = 0x83;
    /**
     * F21 key<br>
     * <i>native declaration : line 282</i>
     */
    public static final int wKC_F21 = 0x84;
    /**
     * F22 key<br>
     * <i>native declaration : line 284</i>
     */
    public static final int wKC_F22 = 0x85;
    /**
     * F23 key<br>
     * <i>native declaration : line 286</i>
     */
    public static final int wKC_F23 = 0x86;
    /**
     * F24 key<br>
     * <i>native declaration : line 288</i>
     */
    public static final int wKC_F24 = 0x87;
    /**
     * NUM LOCK key<br>
     * <i>native declaration : line 290</i>
     */
    public static final int wKC_NUMLOCK = 0x90;
    /**
     * SCROLL LOCK key<br>
     * <i>native declaration : line 292</i>
     */
    public static final int wKC_SCROLL = 0x91;
    /**
     * Left SHIFT key<br>
     * <i>native declaration : line 294</i>
     */
    public static final int wKC_LSHIFT = 0xA0;
    /**
     * Right SHIFT key<br>
     * <i>native declaration : line 296</i>
     */
    public static final int wKC_RSHIFT = 0xA1;
    /**
     * Left CONTROL key<br>
     * <i>native declaration : line 298</i>
     */
    public static final int wKC_LCONTROL = 0xA2;
    /**
     * Right CONTROL key<br>
     * <i>native declaration : line 300</i>
     */
    public static final int wKC_RCONTROL = 0xA3;
    /**
     * Left MENU key<br>
     * <i>native declaration : line 302</i>
     */
    public static final int wKC_LMENU = 0xA4;
    /**
     * Right MENU key<br>
     * <i>native declaration : line 304</i>
     */
    public static final int wKC_RMENU = 0xA5;
    /**
     * Browser Back key<br>
     * <i>native declaration : line 306</i>
     */
    public static final int wKC_BROWSER_BACK = 0xA6;
    /**
     * Browser Forward key<br>
     * <i>native declaration : line 308</i>
     */
    public static final int wKC_BROWSER_FORWARD = 0xA7;
    /**
     * Browser Refresh key<br>
     * <i>native declaration : line 310</i>
     */
    public static final int wKC_BROWSER_REFRESH = 0xA8;
    /**
     * Browser Stop key<br>
     * <i>native declaration : line 312</i>
     */
    public static final int wKC_BROWSER_STOP = 0xA9;
    /**
     * Browser Search key<br>
     * <i>native declaration : line 314</i>
     */
    public static final int wKC_BROWSER_SEARCH = 0xAA;
    /**
     * Browser Favorites key<br>
     * <i>native declaration : line 316</i>
     */
    public static final int wKC_BROWSER_FAVORITES = 0xAB;
    /**
     * Browser Start and Home key<br>
     * <i>native declaration : line 318</i>
     */
    public static final int wKC_BROWSER_HOME = 0xAC;
    /**
     * Volume Mute key<br>
     * <i>native declaration : line 320</i>
     */
    public static final int wKC_VOLUME_MUTE = 0xAD;
    /**
     * Volume Down key<br>
     * <i>native declaration : line 322</i>
     */
    public static final int wKC_VOLUME_DOWN = 0xAE;
    /**
     * Volume Up key<br>
     * <i>native declaration : line 324</i>
     */
    public static final int wKC_VOLUME_UP = 0xAF;
    /**
     * Next Track key<br>
     * <i>native declaration : line 326</i>
     */
    public static final int wKC_MEDIA_NEXT_TRACK = 0xB0;
    /**
     * Previous Track key<br>
     * <i>native declaration : line 328</i>
     */
    public static final int wKC_MEDIA_PREV_TRACK = 0xB1;
    /**
     * Stop Media key<br>
     * <i>native declaration : line 330</i>
     */
    public static final int wKC_MEDIA_STOP = 0xB2;
    /**
     * Play/Pause Media key<br>
     * <i>native declaration : line 332</i>
     */
    public static final int wKC_MEDIA_PLAY_PAUSE = 0xB3;
    /**
     * for US    ";:"<br>
     * <i>native declaration : line 334</i>
     */
    public static final int wKC_OEM_1 = 0xBA;
    /**
     * Plus Key   "+"<br>
     * <i>native declaration : line 336</i>
     */
    public static final int wKC_PLUS = 0xBB;
    /**
     * Comma Key  ","<br>
     * <i>native declaration : line 338</i>
     */
    public static final int wKC_COMMA = 0xBC;
    /**
     * Minus Key  "-"<br>
     * <i>native declaration : line 340</i>
     */
    public static final int wKC_MINUS = 0xBD;
    /**
     * Period Key "."<br>
     * <i>native declaration : line 342</i>
     */
    public static final int wKC_PERIOD = 0xBE;
    /**
     * for US    "/?"<br>
     * <i>native declaration : line 344</i>
     */
    public static final int wKC_OEM_2 = 0xBF;
    /**
     * for US    "`~"<br>
     * <i>native declaration : line 346</i>
     */
    public static final int wKC_OEM_3 = 0xC0;
    /**
     * for US    "[{"<br>
     * <i>native declaration : line 348</i>
     */
    public static final int wKC_OEM_4 = 0xDB;
    /**
     * for US    "\|"<br>
     * <i>native declaration : line 350</i>
     */
    public static final int wKC_OEM_5 = 0xDC;
    /**
     * for US    "]}"<br>
     * <i>native declaration : line 352</i>
     */
    public static final int wKC_OEM_6 = 0xDD;
    /**
     * for US    "'""<br>
     * <i>native declaration : line 354</i>
     */
    public static final int wKC_OEM_7 = 0xDE;
    /**
     * None<br>
     * <i>native declaration : line 356</i>
     */
    public static final int wKC_OEM_8 = 0xDF;
    /**
     * for Japan "AX"<br>
     * <i>native declaration : line 358</i>
     */
    public static final int wKC_OEM_AX = 0xE1;
    /**
     * "<>" or "\|"<br>
     * <i>native declaration : line 360</i>
     */
    public static final int wKC_OEM_102 = 0xE2;
    /**
     * Attn key<br>
     * <i>native declaration : line 362</i>
     */
    public static final int wKC_ATTN = 0xF6;
    /**
     * CrSel key<br>
     * <i>native declaration : line 364</i>
     */
    public static final int wKC_CRSEL = 0xF7;
    /**
     * ExSel key<br>
     * <i>native declaration : line 366</i>
     */
    public static final int wKC_EXSEL = 0xF8;
    /**
     * Erase EOF key<br>
     * <i>native declaration : line 368</i>
     */
    public static final int wKC_EREOF = 0xF9;
    /**
     * Play key<br>
     * <i>native declaration : line 370</i>
     */
    public static final int wKC_PLAY = 0xFA;
    /**
     * Zoom key<br>
     * <i>native declaration : line 372</i>
     */
    public static final int wKC_ZOOM = 0xFB;
    /**
     * PA1 key<br>
     * <i>native declaration : line 374</i>
     */
    public static final int wKC_PA1 = 0xFD;
    /**
     * Clear key<br>
     * <i>native declaration : line 376</i>
     */
    public static final int wKC_OEM_CLEAR = 0xFE;
    /**
     * usually no key mapping, but some laptops use it for fn key<br>
     * <i>native declaration : line 378</i>
     */
    public static final int wKC_NONE = 0xFF;
    /**
     * this is not a key, but the amount of keycodes there are.<br>
     * <i>native declaration : line 382</i>
     */
    public static final int wKC_KEY_CODES_COUNT = 0x100;
};
