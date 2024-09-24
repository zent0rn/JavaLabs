package webProgramming.lab2v1.entity;

import webProgramming.lab2v1.services.impl.GUIDMatcherService;

public class GUID {
    private final String _value;
    private final boolean _isGUID;

    public GUID() {
        _value = "";
        _isGUID = false;
    }

    public GUID(String value) {
        _value = value;
        _isGUID = GUIDMatcherService.match(_value);
    }

    public boolean isGUID() {
        return _isGUID;
    }

    public static GUID[] stringToArrayGUIDs(String input) {
        String[] guidsAsStrings = input.split(" ");
        GUID[] guids = new GUID[guidsAsStrings.length];
        for (int i = 0; i < guidsAsStrings.length; i++) {
            guids[i] = new GUID(guidsAsStrings[i]);
        }
        return guids;
    }
}
