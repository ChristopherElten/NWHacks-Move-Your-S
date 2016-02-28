$ ->
  $.get "/items", (items) ->
    $.each items, (index, item) ->
      $("#items").append $("<li>").text item.name