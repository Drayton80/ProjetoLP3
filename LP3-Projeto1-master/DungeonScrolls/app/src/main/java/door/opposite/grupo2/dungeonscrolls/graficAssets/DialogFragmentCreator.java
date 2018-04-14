package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 *  Esta classe serve para gerar Dialog Fragments com facilidade apenas passando o contexto da view Java pertencente a classe aonde será gerado
 */


public class DialogFragmentCreator {
    Context contextoGeral;
    Animations animacoes = new Animations();

    /** Descrição: esse método gera um Dialog Fragment relativo ao Loading
     *  Parâmetros:
     *      Context contexto - Contexto da classe Java relativa a View em que será exibida o Dialog Fragment
     *      View dialogView  - View a qual possuí a referência para o Dialog Fragment, que nesse caso é o dialogfragment_loadingcircle
     *
     * @param contexto
     * @param dialogView
     */
    public AlertDialog criaDialogFragmentLoadingCircle(Context contexto, View dialogView){
        // Cria um Builder para poder manipular o Dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(contexto);
        // Serve para referenciar a tela (layout) ao qual o Dialog Fragment será exibido em forma de pop-up
        dialogBuilder.setView(dialogView);

        // Cria efetivamente o dialog
        AlertDialog dialog = dialogBuilder.create();
        // Definindo a cor do fundo do Dialog Fragment para transparente:
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // Informando que ao apertar fora do dialog fragment, ele não feche automaticamente
        dialog.setCanceledOnTouchOutside(false);
        // Exibe o dialog
        dialog.show();

        // Chama o método que gera a animação do loading
        animacoes.loadingMagicCircle(dialogView);
        // Método que inicia a animação
        animacoes.startLoadingAnimation();

        // Retorna o dialog para que ele possa ser fechado, caso necessário, com o método fechaDialogFragment
        return dialog;
    }

    /** Descrição: esse método faz o cancelamento e, consquentemente, fecha qualquer dialog fragment que receber
     *  Parâmetros:
     *      AlertDialog dialog - dialog a ser cancelado
     *
     * @param dialog
     */
    public void fechaDialogFragment(AlertDialog dialog){
        dialog.cancel();
    }
}