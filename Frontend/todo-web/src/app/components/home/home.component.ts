import { NgOptimizedImage, CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { ModalComponent } from '../modal/modal.component';
import { ListService } from '../../services/list/list-service';
import { Observable } from 'rxjs';
import { Tarefas } from '../../model/tarefas';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgOptimizedImage, ModalComponent, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  tarefas$: Observable<Tarefas[]>;

  constructor( private listService: ListService){

    this.tarefas$ = this.listService.list();

  }


   descriptionID: number | null = null;

  toggleDescription(id: number){

    this.descriptionID = (this.descriptionID === id) ? null : id;
  }

  isDone(t: Tarefas){
      t.realizado = !t.realizado;
}

  @ViewChild(ModalComponent) modal!: ModalComponent;

  showModal(){
     this.modal.formToggle();
  }

  transPrioridade(t: Tarefas['prioridade']): string{

    if(t === "ALTA"){
      return 'Alta';

    }else if(t === "MEDIA"){
        return 'Média';

      }else{
        return 'Baixa';
      }

  }

  reloadList(){
    this.tarefas$ = this.listService.list();
  }

}
