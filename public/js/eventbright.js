const exampleCallback = function() {
  console.log('Order complete!');
};

window.EBWidgets.createWidget({
  // Required
  widgetType: 'checkout',
  eventId: '380638669507',
  iframeContainerId: 'eventbrite-widget-container-380638669507',

  // Optional
  iframeContainerHeight: 425,  // Widget height in pixels. Defaults to a minimum of 425px if not provided
  onOrderComplete: exampleCallback  // Method called when an order has successfully completed
});
