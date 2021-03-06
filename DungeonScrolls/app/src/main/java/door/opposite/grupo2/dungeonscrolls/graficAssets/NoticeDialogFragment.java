package door.opposite.grupo2.dungeonscrolls.graficAssets;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class NoticeDialogFragment extends DialogFragment {

    /* A Activity cria uma instância para o dialog fragmentThe activity that creates an instance of this dialog fragment must
     * e ela implementa essa interface para receber os "callbacks"
     * esse método é passado para o DialogFragment */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogPositiveClick(DialogFragment dialog, String senha);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use essa instância da interface para enviar os eventos
    NoticeDialogListener mensagem;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verifica se a Activity Host está implementando a interface de "Callback"
        try {
           mensagem = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
           System.out.println("Implements NoticeDialogFragment nessa interface: " + getActivity().toString());
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setMessage("Deseja continuar a exclusão?")
                .setPositiveButton("Deletar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click positivo de volta a Activity Host
                        mensagem.onDialogPositiveClick(NoticeDialogFragment.this);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Envia o Click negativo de volta a Activity Host
                        mensagem.onDialogNegativeClick(NoticeDialogFragment.this);
                    }
                });
        return builder.create();
    }
}
