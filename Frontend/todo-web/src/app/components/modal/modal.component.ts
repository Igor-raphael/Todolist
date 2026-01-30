import { Component, EventEmitter, Output } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { TarefaDTO} from '../../model/TarefaDTO';
import { CreateService } from '../../services/create/create.service';
import { ListService } from '../../services/list/list-service';
import { Tarefas } from '../../model/tarefas';
import { UpdateService } from '../../services/update/update.service';


@Component({
  selector: 'app-modal',
  imports: [NgIf, FormsModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.scss'
})
export class ModalComponent {

  constructor(private createService: CreateService, private listService: ListService, private updateService: UpdateService){}

  showForm: boolean = false;
  overlay: boolean = false;

  EditID: number | null = null;

  tarefa: string = '';
  descricao: string = '';
  realizado: boolean = false;

   prioridades = {
      prioridade: 'BAIXA' as 'BAIXA' | 'MEDIA' | 'ALTA'
   }

   @Output() created = new EventEmitter<void>();

    mode: 'create' | 'edit' = 'create';

   get submitLabel(): string {
    return this.mode === 'edit' ? 'Alterar tarefa' : 'Criar Tarefa';
   }

   createTarefa(){
    this.mode = 'create';
    this.EditID = null;
    this.tarefa = '';
    this.descricao = '';
    this.prioridades.prioridade = 'BAIXA';
    this.formToggle();

   }


   editTarefa(t: Tarefas){
    this.mode = 'edit';
    this.EditID = t.id;
    this.tarefa = t.nome;
    this.descricao = t.descricao;
    this.prioridades.prioridade = t.prioridade;
    this.formToggle();
   }


   onSubmit(form: NgForm){
    if (form.invalid) return;

    if(this.EditID === null){

    const payloadCreate: TarefaDTO = {
      nome: form.value.tarefa,
      descricao: form.value.descricao,
      realizado: false,
      prioridade: form.value.prioridade,

   }

   this.createService.create(payloadCreate).subscribe({

    next: () => {

      this.created.emit();
      form.resetForm({prioridade: 'BAIXA'});
      this.formToggle();
    }

   });

  } else{
    const payloadUpdate = {
      id: this.EditID,
      nome: this.tarefa,
      descricao: this.descricao,
      realizado: this.realizado,
      prioridade: this.prioridades.prioridade
    };


      this.updateService.update(this.EditID,payloadUpdate).subscribe({

        next: () => {
          this.formToggle()
        }


      })


  }

   }

  formToggle(){
    this.showForm = !this.showForm;
    this.overlay = !this.overlay;
  }

}
