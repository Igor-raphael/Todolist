import { Component, EventEmitter, Output } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { TarefaDTO} from '../../model/TarefaDTO';
import { CreateService } from '../../services/create/create.service';
import { ListService } from '../../services/list/list-service';


@Component({
  selector: 'app-modal',
  imports: [NgIf, FormsModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.scss'
})
export class ModalComponent {

  constructor(private createService: CreateService, private listService: ListService){}

  showForm: boolean = false;
  overlay: boolean = false;

  tarefa: string = '';
  descricao: string = '';

   prioridades = {
      prioridade: 'BAIXA' as 'BAIXA' | 'MEDIA' | 'ALTA'
   }

   @Output() created = new EventEmitter<void>();

   onSubmit(form: NgForm){
    if (form.invalid) return;

    const payload: TarefaDTO = {
      nome: form.value.tarefa,
      descricao: form.value.descricao,
      realizado: false,
      prioridade: form.value.prioridade,

   }

   this.createService.create(payload).subscribe({

    next: () => {

      this.created.emit();
      form.resetForm({prioridade: 'BAIXA'});
      this.formToggle();


    }

   });

   }

  formToggle(){
    this.showForm = !this.showForm;
    this.overlay = !this.overlay;
  }

}
