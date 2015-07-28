function hideDialogOnSuccess(args, dialogWidgetVar) {
    if (args && !args.validationFailed) {
        dialogWidgetVar.hide();
    } else {
    	dialogWidgetVar.jq.effect("shake", {
    		times : 5
    	}, 20);
    }
}