// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.map');
goog.require('cljs.core');
goog.require('reagent.core');
dcd_website.map.add_marker_BANG_ = (function dcd_website$map$add_marker_BANG_(mymap,coords){
return L.marker(coords).bindPopup("<a href='http://tq.co' target='_blank'>TQ - Singel 542</a>").addTo(mymap);
});
dcd_website.map.init_tile_layer_BANG_ = (function dcd_website$map$init_tile_layer_BANG_(mymap){
return L.tileLayer("https://api.mapbox.com/styles/v1/gonzih/cixw9sqla002c2sn0a5uqu72s/tiles/256/{z}/{x}/{y}?access_token={accessToken}",cljs.core.clj__GT_js(new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$attribution,"&copy; <a href='http://openstreetmap.org' target='_blank'>OpenStreetMap</a>, <a href='http://creativecommons.org/licenses/by-sa/2.0/' target='_blank'>CC-BY-SA</a>, \u00A9 <a href='http://mapbox.com' target='_blank'>Mapbox</a>",cljs.core.cst$kw$maxZoom,(18),cljs.core.cst$kw$accessToken,"pk.eyJ1IjoiZ29uemloIiwiYSI6ImNpeHc1eDA0NjAwMmczMmw4MnR5b2p4eWsifQ.nrJj6lim59mVefvEwsiCgA"], null))).addTo(mymap);
});
dcd_website.map.init_map_BANG_ = (function dcd_website$map$init_map_BANG_(coords){
var mymap = L.map("location-map",cljs.core.clj__GT_js(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$dcd_DASH_website$map_SLASH_scrollWheelZoom,false], null))).setView(coords,(17));
dcd_website.map.init_tile_layer_BANG_(mymap);

return dcd_website.map.add_marker_BANG_(mymap,coords);
});
dcd_website.map.location_component = (function dcd_website$map$location_component(p__12786){
var map__12789 = p__12786;
var map__12789__$1 = ((((!((map__12789 == null)))?((((map__12789.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12789.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12789):map__12789);
var coords = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12789__$1,cljs.core.cst$kw$coords);
return reagent.core.create_class(new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$reagent_DASH_render,((function (map__12789,map__12789__$1,coords){
return (function (){
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$location,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$p,"Dutch Clojure Days will take place at ",new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,"http://tq.co",cljs.core.cst$kw$target,cljs.core.cst$kw$_blank], null),"TQ"], null)," (Singel 542, 1017 AZ Amsterdam)."], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div_SHARP_location_DASH_map], null)], null);
});})(map__12789,map__12789__$1,coords))
,cljs.core.cst$kw$component_DASH_did_DASH_mount,((function (map__12789,map__12789__$1,coords){
return (function (){
return dcd_website.map.init_map_BANG_(cljs.core.clj__GT_js(coords));
});})(map__12789,map__12789__$1,coords))
], null));
});
