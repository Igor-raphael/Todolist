import { NgOptimizedImage, CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { ModalComponent } from '../modal/modal.component';
import { ListService } from '../../services/list/list-service';
import { Observable } from 'rxjs';
import { Tarefas } from '../../model/tarefas';
import { DeleteService } from '../../services/delete/delete.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgOptimizedImage, ModalComponent, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  tarefas$: Observable<Tarefas[]>;

  @ViewChild(ModalComponent) modal!: ModalComponent;

  constructor(
    private listService: ListService,
    private deleteService: DeleteService,
  ) {
    this.tarefas$ = this.listService.list();
  }

  reloadList() {
    this.tarefas$ = this.listService.list();
  }


  deletePorId(id: number) {
    this.deleteService.delete(id).subscribe({
      next: () => this.reloadList(),
    });
  }


  update(t: Tarefas) {
    this.modal.editTarefa(t);
  }

  createTarefa(){
    this.modal.createTarefa();
  }


  descriptionID: number | null = null;

  toggleDescription(id: number) {
    this.descriptionID = this.descriptionID === id ? null : id;
  }

  isDone(t: Tarefas) {
    t.realizado = !t.realizado;
  }

  transPrioridade(t: Tarefas['prioridade']): string {
    if (t === 'ALTA') {
      return 'Alta';
    } else if (t === 'MEDIA') {
      return 'Média';
    } else {
      return 'Baixa';
    }
  }
}
