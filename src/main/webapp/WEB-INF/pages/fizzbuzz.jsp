<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">


	<!-- Latest compiled and minified JavaScript -->
	<script src="https://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.3.0/knockout-min.js"></script>
</head>
<body style="padding-top: 20px;">
	<div class="container">
		<div class="col-md-10">
			<div data-bind="if: error">
				<div class="form-group alert alert-danger error">
					<p data-bind="text: errorMessage" class="errorMessage">Test</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label" for="fizzBuzzNumber">Enter a number: </label>
				<input data-bind="value: inputValue" class="fizzBuzzNumber form-control" type="number" id="fizzBuzzNumber"/>
			</div>
			<div class="form-group">
				<button data-bind="click: process" class="btn btn-primary btn-block">Process</button>
			</div>

			<div style="padding-top: 20px;" class="form-group">
				<span> Output: <label class="outputValue" data-bind="text: outputValue">text</label></span>
			</div>
		</div>
	</div>

	<script type="application/javascript">
		function AppViewModel() {
			var self = this;
			this.outputValue = ko.observable("");
			this.inputValue = ko.observable(0);
			this.error = ko.observable(false);
			this.errorMessage = ko.observable("");

			this.process = function()
			{
				self.error(false);
				self.error("");

				$.ajax({
					url: "/Process",
					data: {input: self.inputValue()},
					type: 'POST'
				}).done(function(data) {
					self.outputValue(data);
				}).fail(function(err, data){
					self.error(true);
					self.errorMessage(err.responseText);
				});
			}
		}

		// Activates knockout.js
		ko.applyBindings(new AppViewModel());
	</script>
</body>
</html>