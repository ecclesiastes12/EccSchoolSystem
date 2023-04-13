package com.sch.admin.section;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sch.common.entity.Section;

@Service
public class SectionService {

	@Autowired SectionRepository sectionRepo;
	
	//service method that list sections
	public List<Section> listAllSections() {
		return (List<Section>) sectionRepo.findAll();
	}
	
	/*
	 * public List<Section> findAllByName() { return
	 * sectionRepo.findAllSortedByName();
	 * 
	 * }
	 */		  
	
	
	//service method that find section in in order
	/*
	 * public List<Section> findAllByName() { List<Section> unsortedSections =
	 * (List<Section>) sectionRepo.findAll(); return (List<Section>)
	 * sectionRepo.findAll(); }
	 * 
	 * private List<Section> listHierarchicalSections(List<Section>
	 * unsortedSections, Sort sortDir) {
	 * 
	 * for (Section sections : sectionsToSort) { Set<Section> sortedSections =
	 * sections.getName(); } }
	 */
	
	//creates new section
	public Section createSection(Section section) {
		
		return sectionRepo.save(section);
	}
	
	//service method that get section by id
	public Section getSectionId(Integer id) throws SectionNotFoundException {
		
		try {
			return sectionRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new SectionNotFoundException("Cannot find section ID " + id);
		}
	}
	
	//service method that delete section
	public void deleteSection(Integer id) throws SectionNotFoundException {
		
		Long countById = sectionRepo.countById(id);
		if(countById == null || countById == 0) {
			throw new SectionNotFoundException("Cannot find section ID " + id);
		}
		
		sectionRepo.deleteById(id);
	}
}
