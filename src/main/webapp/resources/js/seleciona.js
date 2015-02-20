$('.primeiro').click(function () {
    $(this).addClass('selecionado');
    $('.segundo').removeClass('selecionado');
    $('.terceiro').removeClass('selecionado');
    $('.quarto').removeClass('selecionado');
});

$('.segundo').click(function () {
    $(this).addClass('selecionado');
    $('.primeiro').removeClass('selecionado');
    $('.terceiro').removeClass('selecionado');
    $('.quarto').removeClass('selecionado');
});

$('.terceiro').click(function () {
    $(this).addClass('selecionado');
    $('.primeiro').removeClass('selecionado');
    $('.segundo').removeClass('selecionado');
    $('.quarto').removeClass('selecionado');
});

$('.quarto').click(function () {
    $(this).addClass('selecionado');
    $('.primeiro').removeClass('selecionado');
    $('.segundo').removeClass('selecionado');
    $('.terceiro').removeClass('selecionado');
});