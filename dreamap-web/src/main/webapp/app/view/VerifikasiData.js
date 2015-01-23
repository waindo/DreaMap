var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
Ext.define('app.view.VerifikasiData', {
    extend: 'Ext.window.Window',
    requires: ['Ext.window.Window'],
    layout: 'fit',
    autoShow: true,
    title: 'Verification',
    constrain: true,
    bodyStyle: "background:#ffffff;",
    layout: 'column',
    items: [{
        columnWidth: 1 / 2,
        border: false,
        padding: '5 0 5 5',
        items: [{
            xtype: 'form',
            border: false,
            layout: 'form',
            fieldDefaults: {
                msgTarget: 'side',
                labelWidth: 125
            },
            defaultType: 'textfield',
            items: [{
                fieldLabel: 'Kode WO',
                afterLabelTextTpl: required,
                name: 'kodewo',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your first name'
            }, {
                fieldLabel: 'Jenis Aset',
                afterLabelTextTpl: required,
                name: 'jenisaset',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name'
            }, {
                fieldLabel: 'Status',
                afterLabelTextTpl: required,
                name: 'status',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name'
            }, {
                xtype: 'box',
                autoEl: {
                    tag: 'div',
                    style: 'padding-bottom:20px',
                    html: '<img id="pic" src="resources/images/Google-Maps-icon.png"  width="300px" height="250px" class="img-contact" />'
                }
            }, {
                xtype: 'textarea',
                fieldLabel: 'Keterangan',
                afterLabelTextTpl: required,
                name: 'Keterangan',
                allowBlank: false,
                readOnly: true,
                // tooltip: 'Enter your last name']
            }, {
                xtype: 'radiofield',
                name: 'radio1',
                value: '0',
                fieldLabel: 'Approval',
                boxLabel: 'Not Approved'
            }, {
                xtype: 'radiofield',
                name: 'radio1',
                value: '1',
                checked: true,
                fieldLabel: '',
                labelSeparator: '',
                hideEmptyLabel: false,
                boxLabel: 'Approved'
            }],
        }]
    }, {
        columnWidth: 1 / 2,
        border: false,
        padding: '5 5 5 5',
        layout: 'fit',
        items: [{
            xtype: 'panel',
            layout: 'form',
            border: false,
            items: [{
                xtype: 'filefield',
                emptyText: 'Masukan Sketsa',
                fieldLabel: 'File Sketsa',
                name: 'photo-path',
                buttonText: '',
                buttonConfig: {
                    iconCls: 'upload-icon'
                },
            }, {
                xtype: 'grid',
                hideHeaders: true,
                viewConfig: {
                    stripeRows: true
                },
                height: 115,
                style: 'border: solid #99bce8 1px',
                columns: [{
                    text: 'Nama File'
                }, {
                    text: 'Download'
                }]
            }, {
                xtype: 'grid',
                margin: '5 0 0 0',
                viewConfig: {
                    stripeRows: true
                },
                height: 115,
                style: 'border: solid #99bce8 1px',
                columns: [{
                    text: 'Nama Aset'
                }, {
                    text: 'Status'
                }, {
                    text: 'Keterangan',
                    flex: 1
                }]
            }]
        }]
    }],
    buttons: [{
        text: 'Save',
        handler: function() {
            this.up('window').down('form').getForm().isValid();
        }
    }, {
        text: 'Cancel',
        handler: function() {
            this.up('window').down('form').getForm().reset();
            this.up('window').hide();
        }
    }]



});