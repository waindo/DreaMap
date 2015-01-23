define([
	'esri/InfoTemplate'
], function(InfoTemplate) {
	return {
		// url to your proxy page, must be on same machine hosting you app. See proxy folder for readme.
		proxy: {
			url: "proxy/proxy.ashx",
			alwaysUseProxy: false
		},
		// url to your geometry server.
		geometryService: {
			url: "http://tasks.arcgisonline.com/ArcGIS/rest/services/Geometry/GeometryServer"
		},
		// basemapMode: must be either "agol" or "custom"
		//basemapMode: "custom",
		basemapMode: "agol",
		// defaultBasemap: valid options for "agol" mode: "streets", "satellite", "hybrid", "topo", "gray", "oceans", "national-geographic", "osm"
		//mapStartBasemap: "lightGray",
		mapStartBasemap: "satellite",
		//basemapsToShow: basemaps to show in menu. If "agol" mode use valid values from above, if "custom" mode then define in basmaps dijit and refrenc by name here
		//basemapsToShow: ["street", "satellite", "hybrid", "satTrans", "lightGray"],
		basemapsToShow: ["streets", "satellite", "hybrid", "topo", "gray", "oceans", "national-geographic", "osm"],
		// initialExtent: extent the the map starts at. Helper tool: http://www.arcgis.com/home/item.html?id=dd1091f33a3e4ecb8cd77adf3e585c8a
		initialExtent: {
			xmin: 11889359.721232297,
			ymin: -693510.4768237555,
			xmax: 11891363.8045677,
			ymax: -692390.1966279224,
			spatialReference: {
				wkid: 102100
			}
		},
		// operationalLayers: Array of Layers to load on top of the basemap: valid 'type' options: "dynamic", "tiled", "feature".
		// The 'options' object is passed as the layers options for constructor. Title will be used in the legend only. id's must be unique and have no spaces.
		// 3 'mode' options: MODE_SNAPSHOT = 0, MODE_ONDEMAND = 1, MODE_SELECTION = 2
		operationalLayers: [
		/*{
			type: "feature",
			url: "http://localhost:6080/arcgis/rest/services/ICONPLUS/ICONPLUS/FeatureServer/0",
			title: "Pelanggan Baru",
			options: {
				id: "meteran",
				opacity: 1.0,
				visible: true,
				outFields: ["*"],
				infoTemplate: new InfoTemplate("Meteran", "${*}"),
				mode: 0
			},
			editorLayerInfos: {
				disableGeometryUpdate: false
			}
		}, {
			type: "feature",
			url: "http://localhost:6080/arcgis/rest/services/ICONPLUS/ICONPLUS/FeatureServer/2",
			title: "Jaringan Listrik",
			options: {
				id: "jalis",
				opacity: 1.0,
				visible: true,
				outFields: ["*"],
				infoTemplate: new InfoTemplate("Jaringan", "${*}"),
				mode: 0
			},
			editorLayerInfos: {
				disableGeometryUpdate: false
			}
		}, {
			type: "feature",
			url: "http://localhost:6080/arcgis/rest/services/ICONPLUS/ICONPLUS/FeatureServer/1",
			title: "Tiang Listrik",
			options: {
				id: "tilis",
				opacity: 1.0,
				visible: true,
				outFields: ["*"],
				infoTemplate: new InfoTemplate("Tiang", "${*}"),
				mode: 0
			},
			editorLayerInfos: {
				disableGeometryUpdate: false
			}
		}, */{
			type: "dynamic",
			url: "http://10.25.3.229:6080/arcgis/rest/services/OperationLayer_POSTING/MapServer",
			title: "Fasilitas",
			options: {
				id: "jalan",
				opacity: 1.0,
				visible: true,
			}
		}],
		//widgets: set include to true or false to load or not load the widget. set position to the desired order, starts at 0 on the top.
		widgets: {
			legend: {
				include: true,
				title: "Legend",
				open: false,
				position: 0
			},
			TOC: {
				include: true,
				title: "Layers",
				open: false,
				position: 1
			},
			bookmarks: {
				include: false,
				title: "Bookmarks",
				open: false,
				position: 2
			},
			draw: {
				include: true,
				title: "Drawing Map on The Fly",
				open: false,
				position: 2
			},
			measure: {
				include: true,
				title: "Measurement",
				open: false,
				position: 3,
				defaultAreaUnit: esri.Units.SQUARE_MILES,
				defaultLengthUnit: esri.Units.MILES
			},
			print: {
				include: true,
				title: "Print",
				open: false,
				position: 4,
				serviceURL: "http://sampleserver6.arcgisonline.com/arcgis/rest/services/Utilities/PrintingTools/GPServer/Export%20Web%20Map%20Task",
				copyrightText: "Copyright ESRI 2013",
				authorText: "PLN",
				defaultTitle: 'Jaringan Pelanggan',
				defaultFormat: 'PDF',
				defaultLayout: 'Letter ANSI A Landscape'
			},
			directions: {
				include: false,
				title: "Directions",
				open: false,
				position: 6,
				options: {
					routeTaskUrl: "http://sampleserver3.arcgisonline.com/ArcGIS/rest/services/Network/USA/NAServer/Route",
					routeParams: {
						directionsLanguage: "en-US",
						directionsLengthUnits: "esriMiles"
					}
				}
			},
			editor: {
				include: true,
				title: "Realtime Editing",
				open: false,
				position: 5,
				settings: {
					toolbarVisible: true,
					showAttributesOnClick: true,
					enableUndoRedo: true,
					createOptions: {
						polygonDrawTools: ["freehandpolygon", "autocomplete"]
					},
					toolbarOptions: {
						reshapeVisible: true,
						cutVisible: true,
						mergeVisible: true
					}
				}
			},
			scalebar: {
				include: true,
				options: {
					attachTo: "bottom-left",
					scalebarStyle: "line",
					scalebarUnit: "dual"
				}
			}
		}
	};
});